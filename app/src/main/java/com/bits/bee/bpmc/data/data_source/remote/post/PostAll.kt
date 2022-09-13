package com.bits.bee.bpmc.data.data_source.remote.post

import android.os.Parcelable
import com.bits.bee.bpmc.domain.model.Cadj
import com.bits.bee.bpmc.domain.model.Cstr
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.model.Sale
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal
import java.util.*

@Parcelize
data class PostAll(
    @SerializedName("meta")
    var meta: Meta,
    @SerializedName("sales")
    var salesPostList: MutableList<SalePost>? = mutableListOf(),
    @SerializedName("cadjs")
    var cadjsLIst: MutableList<CadjsPost>? = mutableListOf(),
    @SerializedName("cstrs")
    var cstrPostList: MutableList<CstrPost>? = mutableListOf(),
    @SerializedName("posseses")
    var possesPostList: MutableList<PossesPost>? = mutableListOf()

): Parcelable {
    @Parcelize
    data class Meta(
        @SerializedName("branch_id")
        var branchId: Int? = null,
        @SerializedName("cashier_id")
        var cashierId: Long? = null,
        @SerializedName("sync_at")
        var syncAt: String? = null
    ): Parcelable

    @Parcelize
    data class SalePost(
        @SerializedName("trxno")
        var trxno: String? = null,
        @SerializedName("isvoid")
        var isvoid: Boolean? = null,
        @SerializedName("trxdate")
        var trxdate: String? = null,
        @SerializedName("termtype")
        var termtype: String? = null,
        @SerializedName("cash_id")
        var cashId: Long? = null,
        @SerializedName("branch_id")
        var branchId: Int? = null,
        @SerializedName("bp_id")
        var bpId: Int? = null,
        @SerializedName("trxtype")
        var trxtype: String? = null,
        @SerializedName("created_by")
        var createdBy: Int? = null,
        @SerializedName("updated_by")
        var updatedBy: Int? = null,
        @SerializedName("created_at")
        var createdAt: String? = null,
        @SerializedName("updated_at")
        var updatedAt: String? = null,
        @SerializedName("taxed")
        var taxed: Boolean? = null,
        @SerializedName("taxinc")
        var taxinc: Boolean? = null,
        @SerializedName("crc_id")
        var crcId: Int? = null,
        @SerializedName("excrate")
        var excrate: Int? = null,
        @SerializedName("fisrate")
        var fisrate: Int? = null,
        @SerializedName("billaddr")
        var billaddr: String? = null,
        @SerializedName("shipaddr")
        var shipaddr: String? = null,
        @SerializedName("subtotal")
        var subtotal: Double? = null,
        @SerializedName("basesubtotal")
        var basesubtotal: Double? = null,
        @SerializedName("discamt")
        var discamt: BigDecimal? = null,
        @SerializedName("basediscamt")
        var basediscamt: BigDecimal? = null,
        @SerializedName("discexp")
        var discexp: String? = null,
        @SerializedName("taxamt")
        var taxamt: BigDecimal? = null,
        @SerializedName("basetaxamt")
        var basetaxamt: BigDecimal? = null,
        @SerializedName("basefistaxamt")
        var basefistaxamt: BigDecimal? = null,
        @SerializedName("total")
        var total: Double? = null,
        @SerializedName("basetotal")
        var basetotal: Double? = null,
        @SerializedName("paystatus")
        var paystatus: String? = null,
        @SerializedName("cashier_id")
        var cashier_id: Int? = null,
        @SerializedName("posses_id")
        var possesKode: String? = null,
        @SerializedName("reserved_var1")
        var reserverd_var1: String? = null,
        @SerializedName("rounding")
        var rounding: BigDecimal? = null,
        @SerializedName("channel_id")
        var channel_id: Int? = null,
        @SerializedName("note")
        var note: String? = null,
        @SerializedName("saleds")
        var saleds: MutableList<SaledPost>? = mutableListOf(),
        @SerializedName("salecrcvs")
        var salecrcvs: MutableList<SalecrcvsPost>? = mutableListOf(),
        @SerializedName("salebnss")
        var saleBnsList: MutableList<SaleBns>? = mutableListOf(),
        @SerializedName("salepromos")
        var salePromoList: MutableList<SalePromoPost>? = mutableListOf(),
        @SerializedName("saleaddons")
        var saleaddonList: MutableList<SaleAddOnPost>? = mutableListOf()

    ): Parcelable

        @Parcelize
        data class SaledPost(
            @SerializedName("baseprice")
            var baseprice: String? = null,
            @SerializedName("basesubtotal")
            var basesubtotal: String? = null,
            @SerializedName("basetotaltaxamt")
            var basetotaltaxamt: BigDecimal? = null,
            @SerializedName("basefistotaltaxamt")
            var basefistotaltaxamt: BigDecimal? = null,
            @SerializedName("conv")
            var conv: String? = null,
            @SerializedName("discamt")
            var discamt: String? = null,
            @SerializedName("disc2amt")
            var disc2amt: String? = null,
            @SerializedName("discexp")
            var discexp: String? = null,
            @SerializedName("dno")
            var dno: String? = null,
            @SerializedName("item_id")
            var itemId: String? = null,
            @SerializedName("itemname")
            var itemname: String? = null,
            @SerializedName("listprice")
            var listprice: String? = null,
            @SerializedName("qty")
            var qty: String? = null,
            @SerializedName("subtotal")
            var subtotal: String? = null,
            @SerializedName("taxableamt")
            var taxableamt: String? = null,
            @SerializedName("taxamt")
            var taxamt: String? = null,
            @SerializedName("tax_code")
            var tax_code: String? = null,
            @SerializedName("totaldiscamt")
            var totaldiscamt: String? = null,
            @SerializedName("totaldisc2amt")
            var totaldisc2amt: String? = null,
            @SerializedName("totaltaxamt")
            var totaltaxamt: String? = null,
            @SerializedName("unit")
            var unit: String? = null,
            @SerializedName("wh_id")
            var whId: String? = null
        ): Parcelable

        @Parcelize
        data class SalecrcvsPost(
            @SerializedName("rcvtype_code")
            var rcvtype_code: String? = null,
            @SerializedName("ref_id")
            var ref_id: String? = null,
            @SerializedName("rcvamt")
            var rcvamt: String? = null,
            @SerializedName("note")
            var note: String? = null,
            @SerializedName("edc_id")
            var edc_id: String? = null,
            @SerializedName("cash_id")
            var cash_id: String? = null,
            @SerializedName("card_no")
            var card_no: String? = null,
            @SerializedName("cctype_code")
            var cctype_code: String? = null,
            @SerializedName("mdrexp")
            var mdrexp: String? = null,
            @SerializedName("mdramt")
            var mdramt: String? = null,
            @SerializedName("surcexp")
            var surcexp: String? = null,
            @SerializedName("surcamt")
            var surcamt: String? = null,
            @SerializedName("mdracc_id")
            var mdracc_id: String? = null,
            @SerializedName("surcacc_id")
            var surcacc_id: String? = null,
            @SerializedName("track_no")
            var trackno: String? = null
        ): Parcelable

        @Parcelize
        data class SaleBns(
            var dno: Int? = null,
            var promoId : Int? = null,
            var whId: Long? = null,
            var itemId: Int? = null,
            var unit: String? = null,
            var qty: BigDecimal = BigDecimal.ZERO
        ): Parcelable

        @Parcelize
        data class SalePromoPost(
            @SerializedName("saledno")
            var saledno: Int? = null,
            @SerializedName("promo_id")
            var promo_id: Int? = null,
            @SerializedName("promo_qty")
            var promo_qty: BigDecimal? = null,
            @SerializedName("promo_role")
            var promo_role: String? = null,
            @SerializedName("bp_id")
            var bp_id: Int = 0
        ): Parcelable

        @Parcelize
        data class SaleAddOnPost(
            @SerializedName("up_saled_dno")
            var up_saled_dno: Int = 0,
            @SerializedName("saled_dno")
            var saled_dno: Int = 0
        ): Parcelable

    @Parcelize
    data class CadjsPost(
        @SerializedName("trxno")
        var trxno: String? = null,
        @SerializedName("amount")
        var amount: BigDecimal? = null,
        @SerializedName("cash_id")
        var cashid: Long? = null,
        @SerializedName("reftype")
        var reftype: String? = null,
        @SerializedName("reserved_var1")
        var reserved_var1: String? = null,
        @SerializedName("trxdate")
        var trxdate: String? = null,
        @SerializedName("note")
        var note: String? = null,
        @SerializedName("crc_id")
        var crcId: Int? = null,
        @SerializedName("excrate")
        var excrate: Int? = null,
        @SerializedName("fisrate")
        var fisrate: Int? = null,
        @SerializedName("branch_id")
        var branchId: Int? = null,
        @SerializedName("trxitype")
        private val trxitype: String? = null
    ): Parcelable

    @Parcelize
    data class CstrPost(
        @SerializedName("trxno")
        var trxno: String? = null,
        @SerializedName("trxdate")
        var trxdate: String? = null,
        @SerializedName("branch_id")
        var branch_id: Int? = null,
        @SerializedName("reftype")
        var reftype: String? = null,
        @SerializedName("reserved_var1")
        var refno: String? = null,
        @SerializedName("cash_id1")
        var cash_id1: Long? = null,
        @SerializedName("cash_id2")
        var cash_id2: Long? = null,
        @SerializedName("excrate1")
        var excrate1: BigDecimal? = null,
        @SerializedName("excrate2")
        var excrate2: BigDecimal? = null,
        @SerializedName("amount1")
        var amount1: BigDecimal? = null,
        @SerializedName("amount2")
        var amount2: BigDecimal? = null,
        @SerializedName("note")
        var note: String? = null
    ): Parcelable

    @Parcelize
    data class PossesPost(
        @SerializedName("trxno")
        var trxno: String? = null,
        @SerializedName("trxdate")
        var trxdate: String? = null,
        @SerializedName("cashier_id")
        var cashierId: Int? = null,
        @SerializedName("posses_id")
        var posses_kode: String? = null,
        @SerializedName("shift")
        var shift: String? = null,
        @SerializedName("starttime")
        var starttime: Date? = null,
        @SerializedName("endtime")
        var endtime: Date? = null,
        @SerializedName("startbal")
        var startbal: Double? = null,
        @SerializedName("totin")
        var totin: Double? = null,
        @SerializedName("totout")
        var totout: Double? = null,
        @SerializedName("endbal")
        var endbal: Double? = null,
        @SerializedName("iscollected")
        var iscollected: Boolean? = null,
        @SerializedName("usr_id")
        var usrId: Int? = null,
        @SerializedName("totdiffcash")
        var totDiffCash: BigDecimal? = null,
        @SerializedName("totactualcash")
        var totalActualCash: BigDecimal? = null
    ): Parcelable
}