package com.bits.bee.bpmc.domain.report

import android.content.ContentValues
import android.util.Log
import com.bits.bee.bpmc.domain.model.*
import com.bits.bee.bpmc.domain.repository.*
import com.bits.bee.bpmc.domain.usecase.common.*
import com.bits.bee.bpmc.domain.usecase.pos.GetItemGroupAddOnUseCase
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.DateFormatUtils
import kotlinx.coroutines.flow.first
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by aldi on 03/11/22
 */
@Singleton
class ReportGeneratorInvoice @Inject constructor(
    private val beePreferenceManager: BeePreferenceManager,
    private val getActiveBranchUseCase: GetActiveBranchUseCase,
    private val getSaledBySaleUseCase: GetSaledBySaleUseCase,
    private val saleCrcvRepository: SaleCrcvRepository,
    private val saleRepository: SaleRepository,
    private val saledRepository: SaledRepository,
    private val channelRepository: ChannelRepository,
    private val getSaleAddOnBySaleUseCase: GetSaleAddOnBySaleUseCase,
    private val getSaleAddonDByAddonUseCase: GetSaleAddonDByAddonUseCase,
    private val salePromoRepository: SalePromoRepository,
    private val cadjRepository: CadjRepository,
    private val getItemGroupAddOnUseCase: GetItemGroupAddOnUseCase,
    private val userRepository: UserRepository,
    private val getRegUseCase: GetRegUseCase
) {

    suspend fun printRptInvoice(sale: Sale, maxChar: Int): String {
        val builder = StringBuilder()
        builder.append(ReportHelper.centerString(printHeader(maxChar), maxChar))
        builder.append(BPMConstants.CHAR_ENTER)
        builder.append(BPMConstants.CHAR_ENTER)
        builder.append(printInvoiceHeader(sale, maxChar, false))
        builder.append(printInvoiceSaled(sale, mutableListOf(), maxChar, false))
        builder.append(printInvoiceFooter(sale, maxChar))
        builder.append(ReportHelper.centerString(printFooter(maxChar), maxChar))
        builder.append(BPMConstants.CHAR_ENTER)
        println(builder.toString())
        return builder.toString()
    }

    suspend fun printKitchen(
        sale: Sale,
        kitchen_name: String,
        saleds: List<Saled>,
        maxChar: Int
    ): String {
        val builder = StringBuilder()
        builder.append(ReportHelper.centerString(sale.channel, maxChar))
        builder.append(BPMConstants.CHAR_ENTER)
        builder.append(BPMConstants.CHAR_ENTER)
        builder.append(printHeaderDapur(kitchen_name, maxChar))
        builder.append(printInvoiceHeader(sale, maxChar, true))
        builder.append(printInvoiceSaled(sale, saleds, maxChar, true))
        builder.append(ReportHelper.centerString(printTotalQtyKitchen(saleds), maxChar))
        builder.append(BPMConstants.CHAR_ENTER)
        println(builder.toString())
        return builder.toString()
    }

    private fun printHeaderDapur(name: String, maxChar: Int): String {
        var s = ""
        val builder = StringBuilder(maxChar)
        builder.append("Dapur  : ")
        builder.append(name)
        builder.append(BPMConstants.CHAR_ENTER)
        s += builder
        return s
    }

    suspend fun printRptInvoiceBillGopay(
        sale: Sale,
        maxChar: Int
    ): String {
        val builder = StringBuilder()
        builder.append(ReportHelper.centerString(printHeader(maxChar), maxChar))
        builder.append(BPMConstants.CHAR_ENTER)
        builder.append(BPMConstants.CHAR_ENTER)
        builder.append(printInvoiceHeaderGopay(sale, maxChar))
        builder.append(ReportHelper.generateLine("=", maxChar))
        builder.append(ReportHelper.centerString("TAGIHAN", maxChar))
        builder.append(ReportHelper.generateLine("=", maxChar))
        builder.append(BPMConstants.CHAR_ENTER)
        builder.append(ReportHelper.centerString("SILAHKAN SCAN KODE QR", maxChar))
        builder.append(ReportHelper.centerString("UNTUK MEMBAYAR", maxChar))
        return builder.toString()
    }

    fun printRptFooterBillGopay(sale: Sale, maxChar: Int): String {
        val builder = StringBuilder()
        builder.append(
            ReportHelper.centerString(
                "Rp " + CurrencyUtils.formatCurrency(
                    sale.total,
                ), maxChar
            )
        )
        builder.append(BPMConstants.CHAR_ENTER)
        builder.append(BPMConstants.CHAR_ENTER)
        builder.append(ReportHelper.centerString("*** BUKAN BUKTI PEMBAYARAN ***", maxChar))
        builder.append(BPMConstants.CHAR_ENTER)
        builder.append(BPMConstants.CHAR_ENTER)
        return builder.toString()
    }

    //    untuk cetak struk duplikat
    suspend fun printRptInvoiceDuplicate(sale: Sale, maxChar: Int): String {
        val builder = StringBuilder()
        builder.append(ReportHelper.centerString(printHeader( maxChar), maxChar))
        builder.append(BPMConstants.CHAR_ENTER)
        builder.append(BPMConstants.CHAR_ENTER)
        builder.append(printInvoiceHeader(sale, maxChar, false))
        builder.append(printInvoiceSaled(sale, mutableListOf(), maxChar, false))
        if (sale.isVoid) {
            builder.append(ReportHelper.centerString(printFooterVoid(), maxChar))
        } else {
            builder.append(ReportHelper.centerString(printFooterDuplicate(), maxChar))
        }
        builder.append(printInvoiceFooter(sale, maxChar))
        builder.append(ReportHelper.centerString(printFooter(maxChar), maxChar))
        builder.append(BPMConstants.CHAR_ENTER)
        return builder.toString()
    }

    suspend fun printRptClosingCashierNew(posses: Posses, maxChar: Int): String {
        val notaPreferences = beePreferenceManager.notaPreferences.first()
        val builder = StringBuilder()
        builder.append(ReportHelper.centerString("Rekapitulasi Setoran Kasir", maxChar))
        builder.append(printHeaderRekapKasir(posses, maxChar))
        builder.append(ReportHelper.generateLine("-", maxChar))
        builder.append(printRekapClosingSetoran(posses, maxChar))
        builder.append(BPMConstants.CHAR_ENTER)
        builder.append(ReportHelper.centerString("Pembayaran Tunai", maxChar))
        builder.append(printRekapClosingPaymentCash(posses, maxChar))
        builder.append(BPMConstants.CHAR_ENTER)
        builder.append(ReportHelper.centerString("Pembayaran Non Tunai", maxChar))
        builder.append(printRekapClosingPaymentNonCash(posses, maxChar))
        builder.append(BPMConstants.CHAR_ENTER)
        builder.append(ReportHelper.centerString("Rincian Total Pemasukan", maxChar))
        builder.append(printRekapClosingPayment(posses, maxChar))
        builder.append(ReportHelper.generateLine("=", maxChar))
        builder.append("*Tidak termasuk nota void")
        builder.append(BPMConstants.CHAR_ENTER)
        builder.append(BPMConstants.CHAR_ENTER)
        builder.append(ReportHelper.centerString("Expense", maxChar))
        builder.append(printRekapClosingCashTotal(posses.possesId!!.toLong(), maxChar))
        builder.append(ReportHelper.generateLine("=", maxChar))
        builder.append(BPMConstants.CHAR_ENTER)
        builder.append(ReportHelper.centerString("Rincian Expense", maxChar))
        builder.append(printRekapClosingTransaksiCashInOut(posses.possesId!!.toLong(), maxChar))
        builder.append(ReportHelper.generateLine("=", maxChar))
        builder.append(BPMConstants.CHAR_ENTER)
        builder.append(ReportHelper.centerString("Pembayaran Kartu Debit", maxChar))
        builder.append(printRekapClosingTransaksiNonTunai(posses.possesId!!.toLong(), maxChar, "DC"))
        builder.append(ReportHelper.generateLine("=", maxChar))
        builder.append(BPMConstants.CHAR_ENTER)
        builder.append(ReportHelper.centerString("Pembayaran Kartu Kredit", maxChar))
        builder.append(printRekapClosingTransaksiNonTunai(posses.possesId!!.toLong(), maxChar, "CC"))
        builder.append(ReportHelper.generateLine("=", maxChar))
        builder.append(BPMConstants.CHAR_ENTER)
        val printRekapPerCust = notaPreferences.isRekapCust
        val printRekapPerItem = notaPreferences.isRekapItem
        val printRekapFaktur = notaPreferences.isRekapFaktur
        val printRekapChannel = notaPreferences.isRekapChannel
        val printRekapItemChannel = notaPreferences.isRekapItemChannel
        if (printRekapChannel) {
            builder.append(ReportHelper.centerString("Rekapitulasi Per Channel", maxChar))
            builder.append(printRekapClosingTransaksiChannel(posses.possesId!!.toLong(), maxChar))
            builder.append(ReportHelper.generateLine("=", maxChar))
            builder.append(BPMConstants.CHAR_ENTER)
        }
        if (printRekapPerItem) {
            builder.append(
                ReportHelper.centerString(
                    "Rekapitulasi Total Item Terjual",
                    maxChar
                )
            )
            builder.append(BPMConstants.CHAR_ENTER)
            if (printRekapItemChannel) {
                builder.append(
                    printRekapClosingTransaksiWithDiskonChannel(
                        posses.possesId!!.toLong(),
                        maxChar
                    )
                )
            } else {
                builder.append(
                    printRekapClosingTransaksiWithDiskon(
                        posses.possesId!!.toLong(),
                        maxChar
                    )
                )
            }
        }
        if (printRekapPerCust) {
            builder.append(ReportHelper.generateLine("=", maxChar))
            builder.append(BPMConstants.CHAR_ENTER)
            builder.append(ReportHelper.centerString("Rekapitulasi Per Customer", maxChar))
            builder.append(printRekapClosingCustomer(posses.possesId!!.toLong(), maxChar))
        }
        if (printRekapFaktur) {
            builder.append(
                printRekapFaktur(
                    "Rekap Penjualan Tunai",
                    posses,
                    isCash = true,
                    isVoid = false,
                    maxChar = maxChar
                )
            )
            builder.append(
                printRekapFaktur(
                    "Rekap Penjualan Tunai (Void)",
                    posses,
                    isCash = true,
                    isVoid = true,
                    maxChar = maxChar
                )
            )
            builder.append(
                printRekapFaktur(
                    "Rekap Penjualan Non Tunai",
                    posses,
                    isCash =false,
                    isVoid = false,
                    maxChar = maxChar
                )
            )
            builder.append(
                printRekapFaktur(
                    "Rekap Penj. Non Tunai (Void)",
                    posses,
                    isCash = false,
                    isVoid = true,
                    maxChar = maxChar
                )
            )
        }
        //        builder.append("*Tidak termasuk nota void");
//        builder.append(BPMConstants.CHAR_ENTER);
        builder.append(ReportHelper.generateLine("=", maxChar))
        builder.append(BPMConstants.CHAR_ENTER)
        Log.i("Print Rekap ", builder.toString())
        return builder.toString()
    }

    private suspend fun printHeader(maxChar: Int): String {
        val notaPreferences = beePreferenceManager.notaPreferences.first()
        val branch = getActiveBranchUseCase().first() ?: throw Exception("No branch active!!")
        val companyAddressLong: Int = branch.cmpAddress.length
        var header = notaPreferences.header
        val valHeader = notaPreferences.isLoadLogo

//        jika header belum di set
        if (header.isEmpty() && valHeader && companyAddressLong <= maxChar) {
            header = (branch.cmpName + "\n"
                    + branch.cmpAddress.substring(0, companyAddressLong) + "\n"
                    + branch.name + ", " + branch.cmpPhone + "\n")
        } else if (header.isEmpty() && valHeader && companyAddressLong >= maxChar) {
            header = (branch.cmpName + "\n"
                    + branch.cmpAddress.substring(0, maxChar) + "\n"
                    + branch.cmpAddress.substring(maxChar, companyAddressLong) + "\n"
                    + branch.name + ", " + branch.cmpPhone + "\n")
        } else if (!valHeader) {
            header = ""
        } else if (valHeader && header.isNotEmpty()) {
            if (header.length > maxChar) {
                header = ReportHelper.cutString(header, maxChar)
            }
        }
        return header
    }

    private suspend fun printFooter(maxChar: Int): String {
        val notaPreferences = beePreferenceManager.notaPreferences.first()

        var footer = notaPreferences.footer
        val valFooter = notaPreferences.isFooter

//        jika footer belum di setting
        if (footer.isEmpty() && valFooter) {
            footer = "** Supported by bee.id **"
        } else if (!valFooter) {
            footer = ""
        } else if (valFooter && footer.isNotEmpty()) {
            if (footer.length > maxChar) footer = ReportHelper.cutString(footer, maxChar)
        }
        return footer
    }

    //    footer untuk struk duplikat
    private fun printFooterDuplicate(): String {
        var footer = ""
        footer += "== Duplicate ==\n"
        return footer
    }

    //    footer untuk struk duplikat
    private fun printFooterVoid(): String {
        var footer = ""
        footer += "*** VOID ***\n"
        return footer
    }

    private suspend fun printInvoiceHeader(sale: Sale, maxChar: Int, kitchen: Boolean): String {
        val posPreferences = beePreferenceManager.posPreferences.first()
        var s = ""
        val trxDate = DateFormatUtils.formatDateToString("dd-MM-yyyy kk:mm", sale.trxDate)
        val noOrder = sale.trxNo
        val oprName = sale.userName
        val isEnableCust = posPreferences.isKonfirmasiCust
        val cust = sale.bpName
        val member = sale.bpName
        val channel = channelRepository.getChannelById(sale.channelId).first()?.name ?: ""

        val trxDateB = StringBuilder(maxChar)
        val noOrderB = StringBuilder(maxChar)
        val oprNameB = StringBuilder(maxChar)
        val custMemberB = StringBuilder(maxChar)
        val custB = StringBuilder(maxChar)
        val channelB = StringBuilder(maxChar)
        trxDateB.append("Tanggal: ")
        trxDateB.append(trxDate)
        trxDateB.append(BPMConstants.CHAR_ENTER)
        noOrderB.append("No Trx : ")
        noOrderB.append(noOrder)
        noOrderB.append(BPMConstants.CHAR_ENTER)
        oprNameB.append("Kasir  : ")
        oprNameB.append(oprName)
        oprNameB.append(BPMConstants.CHAR_ENTER)
        custMemberB.append("Member : ")
        custMemberB.append(member)
        custMemberB.append(BPMConstants.CHAR_ENTER)
        custB.append("Cust  : ")
        custB.append(cust)
        custB.append(BPMConstants.CHAR_ENTER)
        channelB.append("Channel: ")
        channelB.append(channel)
        channelB.append(BPMConstants.CHAR_ENTER)
        s += trxDateB
        if (!kitchen) s += oprNameB
        s += noOrderB
        if (!kitchen) s += custMemberB
        if (isEnableCust) {
            s += custB
        }
        if (!kitchen) s += channelB
        s += ReportHelper.generateLine("=", maxChar)
        return s
    }

    private fun printInvoiceHeaderGopay(sale: Sale, maxChar: Int): String {
        var s = ""
        val trxID: String = sale.gopayTransactionId
        val noOrder: String = sale.trxNo
        val trxIdB = StringBuilder(maxChar)
        val noOrderB = StringBuilder(maxChar)
        trxIdB.append("Transaction ID: ")
        trxIdB.append(trxID)
        trxIdB.append(BPMConstants.CHAR_ENTER)
        noOrderB.append("No Trx : ")
        noOrderB.append(noOrder)
        noOrderB.append(BPMConstants.CHAR_ENTER)
        s += trxIdB
        s += noOrderB
        return s
    }

    suspend fun printHeaderRekapKasir(posses: Posses, maxChar: Int): String {
        var s = ""
        val user = userRepository.getUserById(posses.userId).first()
        val trxno: String = posses.trxNo
        val trxDate: String = DateFormatUtils.formatDateToString("dd-MM-yyyy", posses.trxDate)
        val startTime: String = DateFormatUtils.formatDateToString("kk:mm:ss", posses.startTime)
        val endTime: String =
            DateFormatUtils.formatDateToString(BPMConstants.DEFAULT_DATE_FORMAT, posses.endTime ?: Date())
        val startDateTime = String.format("%s %s", trxDate, startTime)
        val endDateTime = String.format("%s", endTime)
        val shift: String = posses.shift.toString()

        val lblTrxDate = StringBuilder(maxChar)
        val lblStartTime = StringBuilder(maxChar)
        val lblEndTime = StringBuilder(maxChar)
        val lblShift = StringBuilder(maxChar)
        val lblOperator = StringBuilder(maxChar)
        //
        lblTrxDate.append("Posses   ")
        lblTrxDate.append(ReportHelper.generateTab(lblTrxDate.toString(), trxno, BPMConstants.BPM_TAB_HEADER_LARGE, maxChar))
        lblTrxDate.append(": ")
        lblTrxDate.append(trxno)
        lblTrxDate.append(BPMConstants.CHAR_ENTER)
        lblStartTime.append("Buka     ")
        lblStartTime.append(ReportHelper.generateTab(lblStartTime.toString(), startDateTime, BPMConstants.BPM_TAB_HEADER_NORMAL, maxChar))
        lblStartTime.append(": ")
        lblStartTime.append(startDateTime)
        lblStartTime.append(BPMConstants.CHAR_ENTER)
        lblEndTime.append("Tutup    ")
        lblEndTime.append(ReportHelper.generateTab(lblEndTime.toString(), endDateTime, BPMConstants.BPM_TAB_HEADER_NORMAL, maxChar))
        lblEndTime.append(": ")
        lblEndTime.append(endDateTime)
        lblEndTime.append(BPMConstants.CHAR_ENTER)
        lblOperator.append("Operator ")
        lblOperator.append(": ")
        lblOperator.append(user.name)
        lblOperator.append(BPMConstants.CHAR_ENTER)
        lblShift.append("Shift    ")
        lblShift.append(": ")
        lblShift.append(shift)
        lblShift.append(BPMConstants.CHAR_ENTER)

        s += lblTrxDate
        s += lblStartTime
        s += lblEndTime
        s += lblOperator
        s += lblShift
        return s
    }


    private suspend fun printInvoiceFooter(sale: Sale, maxChar: Int): String {
        var s = ""
        val saleCrcList = saleCrcvRepository.getSalecrcvBySale(sale.id!!).first()

        val surcamt = if(saleCrcList.isNotEmpty()) CurrencyUtils.formatCurrency(BigDecimal(saleCrcList[0].surcAmt ?: "0")) else ""
        val subTotal: String = CurrencyUtils.formatCurrency(sale.subtotal.setScale(0, RoundingMode.HALF_UP))
        val tax = CurrencyUtils.formatCurrency(sale.taxAmt.setScale(0, RoundingMode.HALF_UP))
        val roundAmt: String = CurrencyUtils.formatCurrency(sale.rounding)
        val discAmt: String = CurrencyUtils.formatCurrency(sale.discAmt)

        var disc2Amt = ""
        if(sale.discExp.isNotEmpty()) {
            disc2Amt = if (sale.discExp.substring(sale.discExp.length - 1).contains("%")) {
                CurrencyUtils.formatCurrency(sale.discAmt)
            } else {
                CurrencyUtils.formatCurrency(BigDecimal(sale.discExp))
            }
        }
        val grandTotal = CurrencyUtils.formatCurrency(sale.total.setScale(0, RoundingMode.HALF_UP))

        val changeAmt = if (sale.termType != BPMConstants.BPM_DEFAULT_TYPE_TUNAI) {
            "0"
        } else {
            CurrencyUtils.formatCurrency(sale.totChange.setScale(0, RoundingMode.HALF_UP))

        }
        val paidAmt = CurrencyUtils.formatCurrency(sale.totPaid.setScale(0, RoundingMode.HALF_UP))

        //
        val subTotalB = StringBuilder(maxChar)
        val taxB = StringBuilder(maxChar)
        val discAmtB = StringBuilder(maxChar)
        val disc2AmtB = StringBuilder(maxChar)
        val grandTotalB = StringBuilder(maxChar)
        val paidAmtB = StringBuilder(maxChar)
        val changeAmtB = StringBuilder(maxChar)
        val surchargeAmtB = StringBuilder(maxChar)
        val roundAmtB = StringBuilder(maxChar)
        //
        for (i in 0 until grandTotalB.capacity()) {
            subTotalB.append(BPMConstants.CHAR_SPACE)
            taxB.append(BPMConstants.CHAR_SPACE)
            surchargeAmtB.append(BPMConstants.CHAR_SPACE)
            discAmtB.append(BPMConstants.CHAR_SPACE)
            disc2AmtB.append(BPMConstants.CHAR_SPACE)
            grandTotalB.append(BPMConstants.CHAR_SPACE)
            paidAmtB.append(BPMConstants.CHAR_SPACE)
            changeAmtB.append(BPMConstants.CHAR_SPACE)
            roundAmtB.append(BPMConstants.CHAR_SPACE)
        }
        //
        val maxLengthArray = IntArray(9)
        var maxLength = 0
        //
        maxLengthArray[0] = subTotal.length
        maxLengthArray[1] = tax.length
        maxLengthArray[2] = surcamt.length
        maxLengthArray[3] = discAmt.length
        maxLengthArray[4] = disc2Amt.length
        maxLengthArray[5] = grandTotal.length
        maxLengthArray[6] = paidAmt.length
        maxLengthArray[7] = changeAmt.length
        maxLengthArray[8] = roundAmt.length
        //
        for (i in maxLengthArray.indices) {
            if (maxLengthArray[i] > maxLength) {
                maxLength = maxLengthArray[i]
            }
        }
        //
        subTotalB.replace(0, "Subtotal".length, "Subtotal")
        subTotalB.replace(subTotalB.capacity() - subTotal.length, subTotalB.capacity(), subTotal + BPMConstants.CHAR_ENTER)
        //
        taxB.replace(0, "Pajak".length, "Pajak")
        taxB.replace(
            taxB.capacity() - tax.length,
            taxB.capacity(),
            tax + BPMConstants.CHAR_ENTER
        )
        surchargeAmtB.replace(0, "Surcharge".length, "Surcharge")
        surchargeAmtB.replace(
            surchargeAmtB.capacity() - surcamt.length,
            surchargeAmtB.capacity(),
            surcamt + BPMConstants.CHAR_ENTER
        )

//        discAmtB.replace(0, "Anda Hemat".length(), "Anda Hemat");
//        discAmtB.replace(discAmtB.capacity()-discAmt.length()-2, discAmtB.capacity(), "("+discAmt+")");
//
        disc2AmtB.replace(0, "Diskon".length, "Diskon")
        disc2AmtB.replace(
            disc2AmtB.capacity() - disc2Amt.length - 2,
            disc2AmtB.capacity(),
            "(" + disc2Amt + ")" + BPMConstants.CHAR_ENTER
        )
        roundAmtB.replace(0, "Pembulatan".length, "Pembulatan")
        roundAmtB.replace(
            roundAmtB.capacity() - roundAmt.length,
            roundAmtB.capacity(),
            roundAmt + BPMConstants.CHAR_ENTER
        )
        //
        grandTotalB.replace(0, "Total".length, "Total")
        grandTotalB.replace(
            grandTotalB.capacity() - grandTotal.length,
            grandTotalB.capacity(),
            grandTotal + BPMConstants.CHAR_ENTER
        )
        val paidType = when(sale.termType){
            BPMConstants.BPM_DEFAULT_TYPE_KREDIT -> "Kartu Kredit"
            BPMConstants.BPM_DEFAULT_TYPE_DEBIT -> "Kartu Debit"
            else -> BPMConstants.BPM_DEFAULT_TYPE_TUNAI
        }
        paidAmtB.replace(0, paidType.length, paidType)
        paidAmtB.replace(
            paidAmtB.capacity() - paidAmt.length,
            paidAmtB.capacity(),
            paidAmt + BPMConstants.CHAR_ENTER
        )
        changeAmtB.replace(0, "Kembalian".length, "Kembalian")
        changeAmtB.replace(
            changeAmtB.capacity() - changeAmt.length,
            changeAmtB.capacity(),
            changeAmt + BPMConstants.CHAR_ENTER
        )
        s += ReportHelper.generateLine("-", maxChar)
        s += subTotalB
        if (disc2Amt != "0" && !disc2Amt.isEmpty()) {
            s += disc2AmtB
        }

        s += taxB

        if (sale.rounding.compareTo(BigDecimal.ZERO) != 0) s += roundAmtB
        if (sale.termType != BPMConstants.BPM_DEFAULT_TYPE_TUNAI) {
            s += surchargeAmtB
        }
        s += grandTotalB
        s += paidAmtB
        s += changeAmtB
        //        s += discAmtB;
        s += ReportHelper.generateLine("=", maxChar)
        return s
    }

    private suspend fun printInvoiceSaled(
        sale: Sale,
        saledList: List<Saled>,
        maxChar: Int,
        kitchen: Boolean
    ): String {
        val saledList1 = if (!kitchen) getSaledBySaleUseCase(sale.id!!).first() else saledList
        val grpAddOn = getItemGroupAddOnUseCase().first()

        var s = ""
        var itemName: String
        var itemQty: String
        var itemPrice: String
        var itemDisc: String
        var itemDiscAmt: String
        var itemSubTotal: String
        var qtyAndPrice: String
        var subTotal: String
        var disc: String
        var note: String
        var spaceQtyAndPrice = ""
        var spaceSubTotal = ""


//        Collections.reverse(saledList);
        for (saled in saledList1) {
            if (grpAddOn == null || (saled.item != null && saled.item!!.itemGrpId != null && saled.item!!.itemGrpId!! != grpAddOn.id)) {
                var maxQtyAndPriceLength = 0
                var maxSubTotalLength = 0
                var itemNameB = StringBuilder(maxChar)
                var itemDetailB = StringBuilder(maxChar)
                var itemDiscB = StringBuilder(maxChar)
                val itemNoteB = StringBuilder(maxChar)
                for (i in 0 until itemNameB.capacity()) {
                    itemNameB.append(BPMConstants.CHAR_SPACE)
                    itemDetailB.append(BPMConstants.CHAR_SPACE)
                    itemDiscB.append(BPMConstants.CHAR_SPACE)
                    itemNoteB.append(BPMConstants.CHAR_SPACE)
                }
                for (j in 0 until itemNameB.capacity()) {
                    itemNameB.replace(j, j + 1, BPMConstants.CHAR_SPACE)
                }
                for (j in 0 until itemDetailB.capacity()) {
                    itemDetailB.replace(j, j + 1, BPMConstants.CHAR_SPACE)
                }
                for (j in 0 until itemDiscB.capacity()) {
                    itemDiscB.replace(j, j + 1, BPMConstants.CHAR_SPACE)
                }
                for (j in 0 until itemNoteB.capacity()) {
                    itemNoteB.replace(j, j + 1, BPMConstants.CHAR_SPACE)
                }
                itemQty = CurrencyUtils.formatCurrency(saled.qty)
                itemName =
                    if (kitchen) itemQty + BPMConstants.CHAR_SPACE + saled.name else saled.name
                itemDisc = saled.discExp
                itemDiscAmt =
                    CurrencyUtils.formatCurrency(
                        saled.totalDiscAmt
                    )

                itemPrice =
                    CurrencyUtils.formatCurrency(
                        saled.listPrice
                    )

                itemSubTotal = CurrencyUtils.formatCurrency(
                    saled.qty.multiply(saled.listPrice)
                        .setScale(2, RoundingMode.HALF_UP)
                )

                if (itemName.length > itemNameB.capacity()) {
                    itemName = itemName.substring(0, itemNameB.capacity())
                }
                if (itemQty.length > maxQtyAndPriceLength) {
                    maxQtyAndPriceLength = itemQty.length
                }
                if (itemSubTotal.length > maxSubTotalLength) {
                    maxSubTotalLength = itemSubTotal.length
                }
                itemNameB.replace(0, itemName.length, itemName)
                itemNameB.replace(
                    itemNameB.capacity() - itemName.length,
                    itemNameB.capacity(),
                    BPMConstants.CHAR_ENTER
                )
                for (j in 0 until maxQtyAndPriceLength) {
                    spaceQtyAndPrice += BPMConstants.CHAR_SPACE
                }
                for (j in 0 until maxSubTotalLength) {
                    spaceSubTotal += BPMConstants.CHAR_SPACE
                }
                qtyAndPrice = BPMConstants.CHAR_SPACE + spaceQtyAndPrice.substring(
                    0,
                    maxQtyAndPriceLength - itemQty.length
                ) + itemQty + " x " + itemPrice
                subTotal = BPMConstants.CHAR_SPACE + spaceSubTotal.substring(
                    0,
                    maxSubTotalLength - itemSubTotal.length
                ) + itemSubTotal
                disc = if (!saled.discExp.contains("%")) {
                    "Disc Rp$itemDisc"
                } else {
                    "Disc $itemDisc"
                }
                itemDetailB.replace(0, qtyAndPrice.length, qtyAndPrice)
                itemDetailB.replace(
                    itemDetailB.capacity() - subTotal.length,
                    itemDetailB.capacity(),
                    itemSubTotal + BPMConstants.CHAR_ENTER
                )
                itemDiscB.replace(0, disc.length, disc)
                itemDiscB.replace(
                    itemDiscB.capacity() - itemDiscAmt.length - 3,
                    itemDiscB.capacity(),
                    "(" + itemDiscAmt + ")" + BPMConstants.CHAR_ENTER
                )
                s += itemName + BPMConstants.CHAR_ENTER
                if (!kitchen) {
                    s += itemDetailB
                }
                if (saled.discAmt > BigDecimal.ONE && !kitchen) {
                    s += itemDiscB
                }

                val listSalePromo = salePromoRepository.getPromoBySaledBonus(sale.id!!, saled.id!!).first()
                if (!kitchen && listSalePromo.isNotEmpty()) s += "Free" + BPMConstants.CHAR_ENTER

                val saleAddOn = getSaleAddOnBySaleUseCase(sale.id!!).first()
                saleAddOn?.let {
                    val saleAddOnDList = getSaleAddonDByAddonUseCase(saleAddOn.id!!).first()
                    for (saleAddOnD in saleAddOnDList) {
                        maxQtyAndPriceLength = 0
                        maxSubTotalLength = 0
                        spaceQtyAndPrice = ""
                        spaceSubTotal = ""
                        maxQtyAndPriceLength = 0
                        maxSubTotalLength = 0
                        itemNameB = StringBuilder(maxChar)
                        itemDetailB = StringBuilder(maxChar)
                        itemDiscB = StringBuilder(maxChar)
                        for (i in 0 until itemNameB.capacity()) {
                            itemNameB.append(BPMConstants.CHAR_SPACE)
                            itemDetailB.append(BPMConstants.CHAR_SPACE)
                            itemDiscB.append(BPMConstants.CHAR_SPACE)
                        }
                        if (saled.dno == saleAddOnD.upSaled?.dno) {
                            val saled1: Saled = saleAddOnD.saled!!
                            for (j in 0 until itemNameB.capacity()) {
                                itemNameB.replace(j, j + 1, BPMConstants.CHAR_SPACE)
                            }
                            for (j in 0 until itemDetailB.capacity()) {
                                itemDetailB.replace(j, j + 1, BPMConstants.CHAR_SPACE)
                            }
                            for (j in 0 until itemDiscB.capacity()) {
                                itemDiscB.replace(j, j + 1, BPMConstants.CHAR_SPACE)
                            }
                            val itemQtyPcs: BigDecimal =
                                saled1.qty.divide(saled.qty)
                            itemQty = CurrencyUtils.formatCurrency(saled1.qty)
                            itemName =
                                if (kitchen) BPMConstants.CHAR_SPACE + "+" + BPMConstants.CHAR_SPACE + itemQtyPcs + BPMConstants.CHAR_SPACE + saled1.name else BPMConstants.CHAR_SPACE + "+" + BPMConstants.CHAR_SPACE + saled1.name
                            itemDisc = CurrencyUtils.formatCurrency(saled1.disc)
                            itemDiscAmt =
                                CurrencyUtils.formatCurrency(
                                    saled1.discAmt
                                )

                            itemPrice =
                                CurrencyUtils.formatCurrency(
                                    saled1.listPrice
                                )

                            itemSubTotal =
                                CurrencyUtils.formatCurrency(
                                    saled1.subtotal
                                ) + " "
                            if (itemName.length > itemNameB.capacity()) {
                                itemName = itemName.substring(0, itemNameB.capacity())
                            }
                            if (itemQtyPcs.toString().length > maxQtyAndPriceLength) {
                                maxQtyAndPriceLength = itemQtyPcs.toString().length
                            }
                            if (itemSubTotal.length > maxSubTotalLength) {
                                maxSubTotalLength = itemSubTotal.length
                            }
                            itemNameB.replace(0, itemName.length, itemName)
                            itemNameB.replace(
                                itemNameB.capacity() - itemName.length,
                                itemNameB.capacity(),
                                BPMConstants.CHAR_ENTER
                            )
                            for (j in 0 until maxQtyAndPriceLength) {
                                spaceQtyAndPrice += BPMConstants.CHAR_SPACE
                            }
                            for (j in 0 until maxSubTotalLength) {
                                spaceSubTotal += BPMConstants.CHAR_SPACE
                            }
                            qtyAndPrice =
                                BPMConstants.CHAR_SPACE + BPMConstants.CHAR_SPACE + BPMConstants.CHAR_SPACE + spaceQtyAndPrice.substring(
                                    0,
                                    maxQtyAndPriceLength - itemQtyPcs.toString().length
                                ) + itemQtyPcs.toString() + " x " + itemPrice
                            subTotal = spaceSubTotal.substring(
                                0,
                                maxSubTotalLength - itemSubTotal.length
                            ) + itemSubTotal
                            disc = if (saled1.discExp.equals("0")) {
                                "Disc Rp$itemDisc"
                            } else {
                                "Disc $itemDisc%"
                            }
                            itemDetailB.replace(0, qtyAndPrice.length, qtyAndPrice)
                            itemDetailB.replace(
                                itemDetailB.capacity() - subTotal.length,
                                itemDetailB.capacity(),
                                itemSubTotal + BPMConstants.CHAR_ENTER
                            )
                            if (itemQty != "1" && saled1.listPrice.compareTo(BigDecimal.ZERO) != 0)
                                itemDetailB.replace(itemDetailB.length / 2, itemDetailB.length / 2 + itemQty.length, itemQty)
                            itemDiscB.replace(0, disc.length, disc)
                            itemDiscB.replace(
                                itemDiscB.capacity() - itemDiscAmt.length - 3,
                                itemDiscB.capacity(),
                                "(" + itemDiscAmt + ")" + BPMConstants.CHAR_ENTER
                            )
                            s += itemName + BPMConstants.CHAR_ENTER
                            if (!kitchen) {
                                if (itemQtyPcs.toInt() >= 1 && saled1.listPrice
                                        .compareTo(
                                            BigDecimal.ZERO
                                        ) != 0
                                ) s += itemDetailB
                            }
                            if (saled1.discAmt > BigDecimal.ONE && !kitchen) {
                                s += itemDiscB
                            }
                        }
                    }
                }


                note = "Note : " + saled.dNotes
                itemNoteB.replace(0, note.length, note)
                if (saled.dNotes.isNotEmpty()) s += itemNoteB
                if (kitchen) s += BPMConstants.CHAR_ENTER
            }
        }
        if (kitchen) {
            s += ReportHelper.generateLine("-", maxChar)
        }
        return s
    }

    private suspend fun printRekapClosingSetoran(posses: Posses, maxChar: Int): String {
        var s = ""
        val saleList = saleRepository.getSaleByPosses(posses.possesId!!).first()
        val cadjList= cadjRepository.getCashInOut(posses.possesId!!.toLong()).first()
        val totAllCash = saleList.filter { it.termType == BPMConstants.BPM_DEFAULT_TYPE_TUNAI && !it.isVoid }.sumOf { it.total }
        val totCash = saleList.filter { !it.isVoid }.sumOf { it.total }
        val totVoid = saleList.filter { it.isVoid }.sumOf { it.total }
        val rounding = saleList.filter { !it.isVoid }.sumOf { it.rounding }
        val totExpIn = cadjList.filter { it.status == "i" }.sumOf { it.amount }
        val totExpOut = cadjList.filter { it.status == "o" }.sumOf { it.amount } * BigDecimal(-1)

        val valRounding = CurrencyUtils.formatCurrency(rounding)
        val valIncome = CurrencyUtils.formatCurrency(totCash.subtract(rounding))
        val valTotExpense = CurrencyUtils.formatCurrency(totExpIn.subtract(totExpOut))

        val lblModal = "Modal"
        val lblIncome = "Penjualan"
        val lblExpense = "Expense"
        val lblRounding = "Pembulatan"
        val lblOmset = "Total Setoran"
        val lblVoid = "Void"
        val lblcountIncome = " (${saleList.filter { !it.isDraft && !it.isVoid }.size})"
        val lblcountVoid = "      (${saleList.filter { it.isVoid }.size}) "
        val valModal: String = CurrencyUtils.formatCurrency(posses.startBal)


        val valOmset = CurrencyUtils.formatCurrency(posses.startBal + (posses.totIn ?: BigDecimal.ZERO) - (posses.totOut ?: BigDecimal.ZERO))
        val valVoid: String = CurrencyUtils.formatCurrency(totVoid)
        s += lblModal
        s += ReportHelper.generateTab(lblModal, valModal, BPMConstants.BPM_TAB_LARGE, maxChar)
        s += valModal
        s += BPMConstants.CHAR_ENTER
        s += lblIncome
        s += lblcountIncome
        s += ReportHelper.generateTab(
            lblIncome + lblcountIncome,
            valIncome, BPMConstants.BPM_TAB_LARGE, maxChar
        )
        s += valIncome
        s += BPMConstants.CHAR_ENTER
        s += lblExpense
        s += ReportHelper.generateTab(
            lblExpense,
            valTotExpense,
            BPMConstants.BPM_TAB_LARGE,
            maxChar
        )
        s += valTotExpense
        s += BPMConstants.CHAR_ENTER
        s += lblRounding
        s += ReportHelper.generateTab(
            lblRounding,
            valRounding,
            BPMConstants.BPM_TAB_LARGE,
            maxChar
        )
        s += valRounding
        s += BPMConstants.CHAR_ENTER
        s += lblOmset
        s += ReportHelper.generateTab(lblOmset, valOmset, BPMConstants.BPM_TAB_LARGE, maxChar)
        s += valOmset
        s += BPMConstants.CHAR_ENTER
        if (totVoid.intValueExact() > 0) {
            s += lblVoid
            s += lblcountVoid
            s += ReportHelper.generateTab(lblVoid, valVoid, 6, maxChar)
            s += valVoid
            s += BPMConstants.CHAR_ENTER
        }
        s += ReportHelper.generateLine("=", maxChar)
        return s
    }

    private suspend fun printRekapClosingPayment(posses: Posses, maxChar: Int): String {
        val saleList = saleRepository.getSaleByPosses(posses.possesId!!).first()
        val cadjList= cadjRepository.getCashInOut(posses.possesId!!.toLong()).first()
        var totDebit = saleList.filter { it.termType == BPMConstants.BPM_DEFAULT_TYPE_DEBIT && !it.isVoid }.sumOf { it.total }
        var totKredit = saleList.filter { it.termType == BPMConstants.BPM_DEFAULT_TYPE_KREDIT && !it.isVoid }.sumOf { it.total }
        val totGopay = saleList.filter { it.termType == BPMConstants.BPM_DEFAULT_TYPE_CASH_GOPAY && !it.isVoid }.sumOf { it.total }
        val totCash = saleList.filter { it.termType == BPMConstants.BPM_DEFAULT_TYPE_TUNAI && !it.isVoid }.sumOf { it.total }
        val totExpIn = cadjList.filter { it.status == "i" }.sumOf { it.amount }
        val totExpOut = cadjList.filter { it.status == "o" }.sumOf { it.amount }

        var s = ""
        val valTotal: String
        val valExpense: String
        val valSurcharge: String
        val lblCash = "Cash"
        val lblDebit = "Debit*"
        val lblKredit = "Kredit*"
        val lblGopay = "Gopay"
        val lblTotal = "Total"
        val lblSaldoAwal = "Saldo Awal"
        val lblSurcharge = "Surcharge"
        val lblExpense = "Expense"
        val lblTotalSetoran = "Total Setoran"
        val surc: BigDecimal
        val expense: BigDecimal
        val totCashIn = totExpIn
        val totCashOut = totExpOut

        val surcDebit: BigDecimal = saleCrcvRepository.getTotalSurchargeByPossesNonCash(posses.possesId!!, "DC").first() ?: BigDecimal.ZERO
        val surcKredit: BigDecimal = saleCrcvRepository.getTotalSurchargeByPossesNonCash(posses.possesId!!, "CC").first() ?: BigDecimal.ZERO

        totDebit = totDebit.subtract(surcDebit)
        totKredit = totKredit.subtract(surcKredit)
        val total: BigDecimal = totCash.add(totDebit).add(totKredit).add(totGopay)
        surc = surcDebit.add(surcKredit)
        expense = totCashIn.add(totCashOut)
        val valCash = CurrencyUtils.formatCurrency(totCash)
        val valDebit = CurrencyUtils.formatCurrency(totDebit)
        val valKredit = CurrencyUtils.formatCurrency(totKredit)
        val valGopay = CurrencyUtils.formatCurrency(totGopay)
        valTotal = CurrencyUtils.formatCurrency(total)
        val valSaldoAwal = CurrencyUtils.formatCurrency(posses.startBal)
        valSurcharge = CurrencyUtils.formatCurrency(surc)
        valExpense = CurrencyUtils.formatCurrency(expense)
        val valTotalSetoran = CurrencyUtils.formatCurrency(posses.endBal)

        s += lblCash
        s += ReportHelper.generateTab(lblCash, valCash, BPMConstants.BPM_TAB_LARGE, maxChar)
        s += valCash
        s += BPMConstants.CHAR_ENTER
        s += lblDebit
        s += ReportHelper.generateTab(lblDebit, valDebit, BPMConstants.BPM_TAB_LARGE, maxChar)
        s += valDebit
        s += BPMConstants.CHAR_ENTER
        s += lblKredit
        s += ReportHelper.generateTab(lblKredit, valKredit, BPMConstants.BPM_TAB_LARGE, maxChar)
        s += valKredit
        s += BPMConstants.CHAR_ENTER
        s += lblGopay
        s += ReportHelper.generateTab(lblGopay, valGopay, BPMConstants.BPM_TAB_LARGE, maxChar)
        s += valGopay
        s += BPMConstants.CHAR_ENTER
        s += ReportHelper.generateLine("-", maxChar)
        s += lblTotal
        s += ReportHelper.generateTab(lblTotal, valTotal, BPMConstants.BPM_TAB_LARGE, maxChar)
        s += valTotal
        s += BPMConstants.CHAR_ENTER
        s += lblSaldoAwal
        s += ReportHelper.generateTab(
            lblSaldoAwal,
            valSaldoAwal,
            BPMConstants.BPM_TAB_LARGE,
            maxChar
        )
        s += valSaldoAwal
        s += BPMConstants.CHAR_ENTER
        s += lblSurcharge
        s += ReportHelper.generateTab(
            lblSurcharge,
            valSurcharge,
            BPMConstants.BPM_TAB_LARGE,
            maxChar
        )
        s += valSurcharge
        s += BPMConstants.CHAR_ENTER
        s += lblExpense
        s += ReportHelper.generateTab(
            lblExpense,
            valExpense,
            BPMConstants.BPM_TAB_LARGE,
            maxChar
        )
        s += valExpense
        s += BPMConstants.CHAR_ENTER
        s += ReportHelper.generateLine("-", maxChar)
        s += lblTotalSetoran
        s += ReportHelper.generateTab(
            lblTotalSetoran,
            valTotalSetoran,
            BPMConstants.BPM_TAB_LARGE,
            maxChar
        )
        s += valTotalSetoran
        s += BPMConstants.CHAR_ENTER
        return s
    }

    private suspend fun printRekapClosingPaymentCash(posses: Posses, maxChar: Int): String {

        val saleList = saleRepository.getSaleByPosses(posses.possesId!!).first()
        val cadjList= cadjRepository.getCashInOut(posses.possesId!!.toLong()).first()
        val totCash = saleList.filter { it.termType == BPMConstants.BPM_DEFAULT_TYPE_TUNAI }.sumOf { it.total }
        val totVoid = saleList.filter { it.termType == BPMConstants.BPM_DEFAULT_TYPE_TUNAI && it.isVoid }.sumOf { it.total }
        val rounding = saleList.filter { !it.isVoid }.sumOf { it.rounding }
        val totExpIn = cadjList.filter { it.status == "i" }.sumOf { it.amount }
        val totExpOut = cadjList.filter { it.status == "o" }.sumOf { it.amount }
        var s = ""
        val valSaldoAwal: String
        val valSetoranKasir: String
        val valSetorButa: String
        val valSelisih: String
        val lblSaldoAwal = "Saldo Awal     :"
        val lblCash = "Nota Tunai     :"
        val lblKasMasuk = "Kas Masuk      :"
        val lblVoid = "Nota Batal     :"
        val lblKasKeluar = "Kas Keluar     :"
        val lblRounding = "Pembulatan     :"
        val lblSetroanKasir = "Setoran Kasir  :"
        val lblSetorButa = "Setor Buta     :"
        val lblSelisih = "Selisih        :"

        val startBal = posses.startBal
        val totalSetoranKasir = startBal.add(totCash).add(totExpIn).subtract(totVoid).add(totExpOut)
        val setorButa = posses.totalActualCash
        val totalSelisih = posses.totalDiffCash

        val possesRegActualPosses: Reg = getRegUseCase(BPMConstants.REG_POSSES_ACTUAL_ENDCASH).first()!!
        valSaldoAwal = CurrencyUtils.formatCurrency(startBal)
        val valCash = CurrencyUtils.formatCurrency(totCash.subtract(rounding))
        val valVoid = "(" + CurrencyUtils.formatCurrency(totVoid) + ")"
        val valKasMasuk = CurrencyUtils.formatCurrency(totExpIn)
        val valRounding = CurrencyUtils.formatCurrency(rounding)
        val valKasKeluar = CurrencyUtils.formatCurrency(totExpOut)
        valSetoranKasir = CurrencyUtils.formatCurrency(totalSetoranKasir)
        valSetorButa = CurrencyUtils.formatCurrency(setorButa)
        valSelisih = "(" + CurrencyUtils.formatCurrency(totalSelisih) + ")"

        s += ReportHelper.generateLine("-", maxChar)
        s += lblSaldoAwal
        s += ReportHelper.generateTab(
            lblSaldoAwal,
            valSaldoAwal,
            BPMConstants.BPM_TAB_LARGE,
            maxChar
        )
        s += valSaldoAwal
        s += BPMConstants.CHAR_ENTER
        s += lblCash
        s += ReportHelper.generateTab(lblCash, valCash, BPMConstants.BPM_TAB_LARGE, maxChar)
        s += valCash
        s += BPMConstants.CHAR_ENTER
        s += lblVoid
        s += ReportHelper.generateTab(lblVoid, valVoid, BPMConstants.BPM_TAB_LARGE, maxChar)
        s += valVoid
        s += BPMConstants.CHAR_ENTER
        s += lblKasMasuk
        s += ReportHelper.generateTab(
            lblKasMasuk,
            valKasMasuk,
            BPMConstants.BPM_TAB_LARGE,
            maxChar
        )
        s += valKasMasuk
        s += BPMConstants.CHAR_ENTER
        s += lblKasKeluar
        s += ReportHelper.generateTab(
            lblKasKeluar,
            valKasKeluar,
            BPMConstants.BPM_TAB_LARGE,
            maxChar
        )
        s += valKasKeluar
        s += BPMConstants.CHAR_ENTER
        s += lblRounding
        s += ReportHelper.generateTab(
            lblRounding,
            valRounding,
            BPMConstants.BPM_TAB_LARGE,
            maxChar
        )
        s += valRounding
        s += BPMConstants.CHAR_ENTER
        s += ReportHelper.generateSpace(lblCash.length)
        s += ReportHelper.generateLineCustom("-", maxChar - lblCash.length - 1)
        s += lblSetroanKasir
        s += ReportHelper.generateTab(
            lblSetroanKasir,
            valSetoranKasir,
            BPMConstants.BPM_TAB_LARGE,
            maxChar
        )
        s += valSetoranKasir
        s += BPMConstants.CHAR_ENTER
        if (possesRegActualPosses.value == "1") {
            s += lblSetorButa
            s += ReportHelper.generateTab(
                lblSetorButa,
                valSetorButa,
                BPMConstants.BPM_TAB_LARGE,
                maxChar
            )
            s += valSetorButa
            s += BPMConstants.CHAR_ENTER
            s += ReportHelper.generateSpace(lblCash.length)
            s += ReportHelper.generateLineCustom("-", maxChar - lblCash.length - 1)
            s += BPMConstants.CHAR_ENTER
            s += lblSelisih
            s += ReportHelper.generateTab(
                lblSelisih,
                valSelisih,
                BPMConstants.BPM_TAB_LARGE,
                maxChar
            )
            s += valSelisih
        }
        s += BPMConstants.CHAR_ENTER
        Log.d("RekapClose", "printRekapClosingPaymentCash: $s")
        return s
    }

    private suspend fun printRekapClosingPaymentNonCash(posses: Posses, maxChar: Int): String {
        var s = ""
        val saleList = saleRepository.getSaleByPosses(posses.possesId!!).first()
        val totDebit = saleList.filter { it.termType == BPMConstants.BPM_DEFAULT_TYPE_DEBIT }.sumOf { it.total }
        val totKredit = saleList.filter { it.termType == BPMConstants.BPM_DEFAULT_TYPE_KREDIT }.sumOf { it.total }
        val totGopay = saleList.filter { it.termType == BPMConstants.BPM_DEFAULT_TYPE_CASH_GOPAY }.sumOf { it.total }
        val totVoidNonCash = saleList.filter { it.termType != BPMConstants.BPM_DEFAULT_TYPE_TUNAI && it.isVoid }.sumOf { it.total }
        val totRoundVoidNonCash = saleList.filter { it.termType != BPMConstants.BPM_DEFAULT_TYPE_TUNAI && it.isVoid }.sumOf { it.rounding }

        val valDebit: String
        val valKredit: String
        val valGopay: String
        val valVoid: String
        val valRounding: String
        val valTotalNonTunai: String
        val valSurcharge: String
        val valTotal: String
        val lblDebit = "Debit*         :"
        val lblKredit = "Kredit*        :"
        val lblGopay = "Gopay          :"
        val lblVoid = "Non Tunai Batal:"
        val lblTotalNonTunai = "Non Tunai Total:"
        val lblRounding = "Pembulatan     :"
        val lblSurcharge = "Surcharge      :"
        val lblTotal = "Total          :"

        val surcDebit = saleCrcvRepository.getTotalSurchargeByPossesNonCashAll(posses.possesId!!, "DC").first() ?: BigDecimal.ZERO
        val totalDebit: BigDecimal = totDebit.subtract(surcDebit)
        val surcCredit: BigDecimal = saleCrcvRepository.getTotalSurchargeByPossesNonCashAll(posses.possesId!!, "CC").first()  ?: BigDecimal.ZERO
        val totalKredit: BigDecimal = totKredit.subtract(surcCredit)
        val totalGopay: BigDecimal = totGopay
        val surcVoid: BigDecimal = saleCrcvRepository.getTotalSurchargeByPossesVoid(posses.possesId!!).first()  ?: BigDecimal.ZERO
        val totalVoid: BigDecimal = totVoidNonCash.subtract(surcVoid)
        val totalNonTunai = totalDebit.add(totalKredit).add(totalGopay).subtract(totalVoid)
        val totalRounding: BigDecimal = totRoundVoidNonCash
        val totalSurcharge: BigDecimal = saleCrcvRepository.getTotalSurchargeByPosses(posses.possesId!!).first() ?: BigDecimal.ZERO
        val total = totalNonTunai.add(totalSurcharge)
        valDebit = CurrencyUtils.formatCurrency(totalDebit)
        valKredit = CurrencyUtils.formatCurrency(totalKredit)
        valGopay = CurrencyUtils.formatCurrency(totalGopay)
        valVoid = "(" + CurrencyUtils.formatCurrency(totalVoid) + ")"
        valTotalNonTunai =
            CurrencyUtils.formatCurrency(totalNonTunai)
        valRounding = CurrencyUtils.formatCurrency(totalRounding)
        valSurcharge = CurrencyUtils.formatCurrency(totalSurcharge)
        valTotal = CurrencyUtils.formatCurrency(total)

        s += ReportHelper.generateLine("-", maxChar)
        s += lblDebit
        s += ReportHelper.generateTab(lblDebit, valDebit, BPMConstants.BPM_TAB_LARGE, maxChar)
        s += valDebit
        s += BPMConstants.CHAR_ENTER
        s += lblKredit
        s += ReportHelper.generateTab(lblKredit, valKredit, BPMConstants.BPM_TAB_LARGE, maxChar)
        s += valKredit
        s += BPMConstants.CHAR_ENTER
        s += lblGopay
        s += ReportHelper.generateTab(lblGopay, valGopay, BPMConstants.BPM_TAB_LARGE, maxChar)
        s += valGopay
        s += BPMConstants.CHAR_ENTER
        s += lblVoid
        s += ReportHelper.generateTab(lblVoid, valVoid, BPMConstants.BPM_TAB_LARGE, maxChar)
        s += valVoid
        s += BPMConstants.CHAR_ENTER
        s += ReportHelper.generateSpace(lblKredit.length)
        s += ReportHelper.generateLineCustom("-", maxChar - lblKredit.length - 1)
        s += lblTotalNonTunai
        s += ReportHelper.generateTab(
            lblTotalNonTunai,
            valTotalNonTunai, BPMConstants.BPM_TAB_LARGE, maxChar
        )
        s += valTotalNonTunai
        s += BPMConstants.CHAR_ENTER
        s += lblRounding
        s += ReportHelper.generateTab(
            lblRounding,
            valRounding,
            BPMConstants.BPM_TAB_LARGE,
            maxChar
        )
        s += valRounding
        s += BPMConstants.CHAR_ENTER
        s += lblSurcharge
        s += ReportHelper.generateTab(
            lblSurcharge,
            valSurcharge, BPMConstants.BPM_TAB_LARGE, maxChar
        )
        s += valSurcharge
        s += BPMConstants.CHAR_ENTER
        s += ReportHelper.generateSpace(lblKredit.length)
        s += ReportHelper.generateLineCustom("-", maxChar - lblKredit.length - 1)
        s += BPMConstants.CHAR_ENTER
        s += lblTotal
        s += ReportHelper.generateTab(lblTotal, valTotal, BPMConstants.BPM_TAB_LARGE, maxChar)
        s += valTotal
        s += BPMConstants.CHAR_ENTER
        s += BPMConstants.CHAR_ENTER
        s += "*Tidak termasuk surcharge"
        s += BPMConstants.CHAR_ENTER
        return s
    }

    private suspend fun printRekapFaktur(title: String, posses: Posses, isCash: Boolean, isVoid: Boolean, maxChar: Int): String {
        var s = ""
        var saleList: List<Sale> = ArrayList<Sale>()
        val termType = if (isCash) "tunai" else "Debit Card"
        try {
            saleList = saleRepository.getSaleByPosses(posses.possesId!!, isVoid, termType).first()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        if (saleList.isNotEmpty()) {
            s += ReportHelper.centerString(title, maxChar)
            s += ReportHelper.generateLine("=", maxChar)
            var grandtotal = BigDecimal.ZERO
            for (sale in saleList) {
                val total: String = CurrencyUtils.formatCurrency(sale.total)
                s += sale.trxNo
                s += ReportHelper.generateTab(
                    sale.trxNo,
                    total,
                    BPMConstants.BPM_TAB_LARGE,
                    maxChar
                )
                s += total
                s += BPMConstants.CHAR_ENTER
                grandtotal = grandtotal.add(sale.total)
            }
            s += ReportHelper.generateLine("=", maxChar)
            val totalNota = saleList.size.toString() + " Nota"
            val grand: String = CurrencyUtils.formatCurrency(grandtotal)
            s += totalNota
            s += ReportHelper.generateTab(totalNota, grand, BPMConstants.BPM_TAB_LARGE, maxChar)
            s += grand
            s += BPMConstants.CHAR_ENTER
            s += BPMConstants.CHAR_ENTER
        }
        return s
    }

    private suspend fun printRekapClosingCashTotal(cashId: Long, maxChar: Int): String {
        var s = ""
        val cadjList= cadjRepository.getCashInOut(cashId).first()
        val totExpIn = cadjList.filter { it.status == "i" }.sumOf { it.amount }
        val totExpOut = cadjList.filter { it.status == "o" }.sumOf { it.amount }

        val lblCashIn = "Kas Masuk"
        val lblCashOut = "Kas Keluar"

        val valCashIn: String = CurrencyUtils.formatCurrency(totExpIn)

        val valCashOut: String = "(" + CurrencyUtils.formatCurrency(totExpOut)+ ")"

        s += lblCashIn
        s += ReportHelper.generateTab(lblCashIn, valCashIn, BPMConstants.BPM_TAB_LARGE, maxChar)
        s += valCashIn
        s += BPMConstants.CHAR_ENTER
        s += lblCashOut
        s += ReportHelper.generateTab(lblCashOut, valCashOut, BPMConstants.BPM_TAB_LARGE, maxChar)
        s += valCashOut
        s += BPMConstants.CHAR_ENTER

        return s
    }

    private suspend fun printRekapClosingTransaksiWithDiskon(possesID: Long, maxChar: Int): String {
        var s = ""
        val saleList = saleRepository.getSaleByPosses(possesID.toInt()).first()
        val totPaid = saleList.filter { !it.isVoid }.sumOf { it.total }

        var valItem: String
        var valQty: String
        var valPrice: String
        var valTotal: String
        var discount: String
        var discountAmt: String
        val valTotalTrx = CurrencyUtils.formatCurrency(totPaid)
        var detailPlaceholder: String
        val mSaledList = saledRepository.getSaledByPosses(possesID.toInt()).first()
        val lblTotalTrx = "Total Setoran "


        for (saleds in mSaledList) {
            valItem = saleds.name
            valQty = CurrencyUtils.formatCurrency(saleds.qty)
            valPrice = CurrencyUtils.formatCurrency(saleds.listPrice)
            valTotal = CurrencyUtils.formatCurrency(saleds.listPrice.multiply(saleds.qty))
            detailPlaceholder = BPMConstants.CHAR_SPACE + valQty + " x " + valPrice
            s += valItem + BPMConstants.CHAR_ENTER
            s += detailPlaceholder
            s += ReportHelper.generateTab(
                detailPlaceholder,
                valTotal,
                BPMConstants.BPM_TAB_LARGE,
                maxChar
            )
            s += valTotal
            s += BPMConstants.CHAR_ENTER
            val listsaledspersen = saledRepository.getRekapSaledDiskon(possesID.toInt(), saleds.itemId, saleds.listPrice).first()

            if (listsaledspersen.isNotEmpty()) {
                for (saledspersen in listsaledspersen) {
                    discount = if (saledspersen.discExp.contains("%"))
                        "Disc " + saledspersen.discExp else "Disc " + CurrencyUtils.formatCurrency(saledspersen.disc)

                    discountAmt = "(" + CurrencyUtils.formatCurrency(saledspersen.totalDiscAmt) + ")"
                    if (saledspersen.discAmt.compareTo(BigDecimal.ZERO) != 0) {
                        s += discount
                        s += ReportHelper.generateTab(
                            discount,
                            discountAmt,
                            BPMConstants.BPM_TAB_LARGE,
                            maxChar
                        )
                        s += discountAmt
                        s += BPMConstants.CHAR_ENTER
                    }
                }
            }
        }
        s += ReportHelper.generateLine("-", maxChar)
        s += lblTotalTrx
        s += ReportHelper.generateTab(lblTotalTrx, valTotalTrx, 1, maxChar)
        s += valTotalTrx
        s += BPMConstants.CHAR_ENTER
        return s
    }

    private suspend fun printRekapClosingTransaksiWithDiskonChannel(possesID: Long, maxChar: Int): String {
        var s = ""

        var valItem: String
        var valQty: String
        var valPrice: String
        var valTotal: String
        var discount: String
        var discountAmt: String
        var valNamaMember : String
        var lblTotalTrx: String
        var valTotalTrx: String
        val saleList = saleRepository.getSaleByPossesGroupChannel(possesID.toInt()).first()
        var detailPlaceholder: String

        for (sale in saleList) {
            val mSaledList = saledRepository.getSaledByPossesChannel(possesID.toInt(), sale.channelId).first()
            val totPaidChannel = saleList.filter { !it.isVoid && it.channelId == sale.channelId }.sumOf { it.total }
            var namaChannel = "(Tanpa Channel)"
            if (sale.channelId != 0) {
                val channel = channelRepository.getChannelById(sale.channelId).first()
                if (channel != null) {
                    namaChannel = channel.name
                }
            }
            valNamaMember = "Channel : $namaChannel"

            lblTotalTrx = "Total Setoran "

            valTotalTrx = CurrencyUtils.formatCurrency(totPaidChannel)

            s += ReportHelper.generateLine("-", maxChar)
            s += valNamaMember + BPMConstants.CHAR_ENTER

            for (saleds in mSaledList) {
                valItem = saleds.name
                valQty = CurrencyUtils.formatCurrency(saleds.qty)
                valPrice = CurrencyUtils.formatCurrency(saleds.listPrice)
                valTotal = CurrencyUtils.formatCurrency(saleds.subtotal)
                detailPlaceholder = BPMConstants.CHAR_SPACE + valQty + " x " + valPrice
                s += valItem + BPMConstants.CHAR_ENTER
                s += detailPlaceholder
                s += ReportHelper.generateTab(
                    detailPlaceholder,
                    valTotal,
                    BPMConstants.BPM_TAB_LARGE,
                    maxChar
                )
                s += valTotal
                s += BPMConstants.CHAR_ENTER
                val listsaledspersen = saledRepository.getRekapSaledDiskon(possesID.toInt(), saleds.itemId, sale.channelId).first()

                if (listsaledspersen.isNotEmpty()) {
                    for (saledspersen in listsaledspersen) {
                        discount = if (saledspersen.discExp.contains("%"))
                            "Disc " + saledspersen.discExp else "Disc " + CurrencyUtils.formatCurrency(saledspersen.disc)
                        discountAmt = "(" + CurrencyUtils.formatCurrency(saledspersen.totalDiscAmt) + ")"

                        if (saledspersen.discAmt.compareTo(BigDecimal.ZERO) != 0) {
                            s += discount
                            s += ReportHelper.generateTab(
                                discount,
                                discountAmt,
                                BPMConstants.BPM_TAB_LARGE,
                                maxChar
                            )
                            s += discountAmt
                            s += BPMConstants.CHAR_ENTER
                        }
                    }
                }
            }
            s += lblTotalTrx
            s += ReportHelper.generateTab(lblTotalTrx, valTotalTrx, 1, maxChar)
            s += valTotalTrx
            s += BPMConstants.CHAR_ENTER
        }
        return s
    }

    private suspend fun printRekapClosingTransaksiCashInOut(possesID: Long, maxChar: Int): String {
        var s = ""
        var valItem: String
        var valTotal: String
        val listcadj = cadjRepository.getCashInOut(possesID).first()

        for (cadjs in listcadj) {
            valItem = cadjs.note
            valTotal = CurrencyUtils.formatCurrency(cadjs.amount)
            s += valItem
            s += ReportHelper.generateTab(
                valItem,
                valTotal,
                BPMConstants.BPM_TAB_LARGE,
                maxChar
            )
            s += valTotal
            s += BPMConstants.CHAR_ENTER
        }
        return s
    }

    private suspend fun printRekapClosingTransaksiChannel(possesID: Long, maxChar: Int): String {
        var s = ""
        val saleList = saleRepository.getSaleByPosses(possesID.toInt()).first()
        var total: BigDecimal
        var count: BigDecimal
        var totalCount = BigDecimal.ZERO
        var grandtotal = BigDecimal.ZERO
        val channelList = channelRepository.getActiveChannelList().first()

        for (channel in channelList) {
            total = saleList.filter { it.channelId == channel.id }.sumOf { it.total }
            count = saleList.filter { it.channelId == channel.id }.size.toBigDecimal()
            grandtotal = grandtotal.add(total)
            totalCount = totalCount.add(count)
            s += printRekapPerChannelDetail(total, count, channel, maxChar)
        }

        // channel kosong
        total = saleList.filter { it.channelId == 0 }.sumOf { it.total }
        count = saleList.filter { it.channelId == 0 }.size.toBigDecimal()
        grandtotal = grandtotal.add(total)
        totalCount = totalCount.add(count)

        s += printRekapPerChannelDetail(total, count, null, maxChar)

        val totalNota = "$totalCount Nota"
        val valGrandtotal: String =
            CurrencyUtils.formatCurrency(grandtotal)
        s += ReportHelper.generateLine("-", maxChar)
        s += totalNota
        s += ReportHelper.generateTab(
            totalNota,
            valGrandtotal,
            BPMConstants.BPM_TAB_LARGE,
            maxChar
        )
        s += valGrandtotal
        s += BPMConstants.CHAR_ENTER
        return s
    }

    private fun printRekapPerChannelDetail(total: BigDecimal, count: BigDecimal, channel: Channel?, maxChar: Int): String {
        var s = ""
        val valItem =
            if (channel != null) String.format(
                "%s (%s)",
                channel.name,
                count.toString()
            ) else "(Tanpa Channel)"
        val valTotal = CurrencyUtils.formatCurrency(total)
        s += valItem
        s += ReportHelper.generateTab(valItem, valTotal, BPMConstants.BPM_TAB_LARGE, maxChar)
        s += valTotal
        s += BPMConstants.CHAR_ENTER
        return s
    }

    private suspend fun printRekapClosingCustomer(possesID: Long, maxChar: Int): String {
        var s = ""
        val headerCust = "Customer"
        val headerTotal = "Total"
        val saleList = saleRepository.getSaleByPossesGroupByBp(possesID.toInt()).first()
        s += ReportHelper.generateLine("-", maxChar)
        s += headerCust
        s += ReportHelper.generateTab(
            headerCust,
            headerTotal,
            BPMConstants.BPM_TAB_LARGE,
            maxChar
        )
        s += headerTotal
        s += BPMConstants.CHAR_ENTER
        for (sale in saleList) {
            val name = sale.bpName
            s += name
            s += ReportHelper.generateTab(
                name,
                CurrencyUtils.formatCurrency(sale.total),
                BPMConstants.BPM_TAB_LARGE,
                maxChar
            )
            s += CurrencyUtils.formatCurrency(sale.total)
            s += BPMConstants.CHAR_ENTER
        }
        s += BPMConstants.CHAR_ENTER
        return s
    }

    private suspend fun printRekapClosingTransaksiNonTunai(possesID: Long, maxChar: Int, rcvtype: String) : String {
        val salecrcvsList = saleCrcvRepository.getSalecrcvByPosses(possesID.toInt(), rcvtype).first()
        var s = ""
        val headerTrackno = "Trackno"
        val headerNominal = "Nominal"

        s += ReportHelper.generateLine("-", maxChar)
        s += headerTrackno
        s += ReportHelper.generateTab(
            headerTrackno,
            headerNominal,
            BPMConstants.BPM_TAB_LARGE,
            maxChar
        )
        s += headerNominal
        s += BPMConstants.CHAR_ENTER
        for (salecrcvs in salecrcvsList) {
            s += if (salecrcvs.trackNo == null) salecrcvs.cardNo else salecrcvs.trackNo
            s += ReportHelper.generateTab((if (salecrcvs.trackNo == null) salecrcvs.cardNo else salecrcvs.trackNo) ?: "",
                CurrencyUtils.formatCurrency(BigDecimal(salecrcvs.rcvAmt)),
                BPMConstants.BPM_TAB_LARGE,
                maxChar
            )
            s += CurrencyUtils.formatCurrency(BigDecimal(salecrcvs.rcvAmt))
            s += BPMConstants.CHAR_ENTER
        }
        return s
    }

    private fun printTotalQtyKitchen(saledList: List<Saled>): String {
        var totalQty = BigDecimal.ZERO
        for (saled in saledList) {
            totalQty = saled.qty.add(totalQty)
        }
        val sb = StringBuilder()
        sb.append("Total Qty : ")
        sb.append(totalQty)
        return sb.toString()
    }

}