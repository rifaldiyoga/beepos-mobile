package com.bits.bee.bpmc.presentation.ui.setting_printer.list_printer

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.*
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentSettingListPrinterBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.BluetoothHandlerReceiver
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListPrinterFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSettingListPrinterBinding = FragmentSettingListPrinterBinding::inflate
): BaseFragment<FragmentSettingListPrinterBinding>() {

    lateinit var mBluetoothAdapter: BluetoothAdapter
    lateinit var mDevice: BluetoothDevice
    var deviceName = "My_Device_Name"
    private var mListPrinter: MutableList<ListPrinter> = mutableListOf()
    lateinit var findPrinterAdapter: FindPrinterAdapter
    private val REQUEST_ENABLE_BLUETOOTH = 1
    private lateinit var m_pairedDevices: Set<BluetoothDevice>
    val viewModel: FindPrinterViewModel by viewModels()

    override fun initComponents() {
        init()
        enableDiscover()
        evenDiscover()
    }

    fun init(){
        mBluetoothAdapter= BluetoothAdapter.getDefaultAdapter()
        if(mBluetoothAdapter == null) {
            Toast.makeText(requireContext(), "this device doesn't support bluetooth", Toast.LENGTH_LONG)
                .show()
            return
        }
        if(!mBluetoothAdapter!!.isEnabled) {
            val enableBluetoothIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(enableBluetoothIntent, REQUEST_ENABLE_BLUETOOTH)
        }
        m_pairedDevices = mBluetoothAdapter!!.bondedDevices
        if (!m_pairedDevices.isEmpty()) {
            for (device: BluetoothDevice in m_pairedDevices) {
                if (deviceName.equals(device.name)){
                    mDevice = device
                    break
                }
                mListPrinter.add(ListPrinter(device.name, device.address))
                Log.d(ContentValues.TAG, "paired device: {${device!!.name} ${device.address}} ")
            }
        } else {
            Toast.makeText(requireContext(), "bluetooth device not found", Toast.LENGTH_LONG)
                .show()
        }
    }

    fun stopDiscovery(){
        if (mBluetoothAdapter.isDiscovering){
            mBluetoothAdapter.cancelDiscovery()
        }
//        binding.clListPBar.visibility = View.GONE
        requireContext().unregisterReceiver(receiver)
    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {

    }

    fun enableDiscover(){
        val discoverableIntent = Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE)
        discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300)
        startActivity(discoverableIntent)

        val intentFilter = IntentFilter(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED)
        requireContext().registerReceiver(receiver2, intentFilter)
    }

    fun evenDiscover(){
        if (mBluetoothAdapter.isDiscovering){
            mBluetoothAdapter.cancelDiscovery()
            Log.d(ContentValues.TAG, "Discovery: cancelling discover.")

            checkBTPermission()

            mBluetoothAdapter.startDiscovery()
            val filter = IntentFilter(BluetoothDevice.ACTION_FOUND)
            requireContext().registerReceiver(receiver, filter)
        }
        if (!mBluetoothAdapter.isDiscovering){
            checkBTPermission()

            mBluetoothAdapter.startDiscovery()
            binding.clListPBar.visibility = View.VISIBLE
            val filter = IntentFilter(BluetoothDevice.ACTION_FOUND)
            requireContext().registerReceiver(receiver, filter)
        }
    }

    fun checkBTPermission(){
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            var permissionCheck =
                requireContext()!!.checkSelfPermission("Manifest.permission.ACCESS_FINE_LOCATION")
            permissionCheck += requireContext()!!.checkSelfPermission("Manifest.permission.ACCESS_COARSE_LOCATION")
            if (permissionCheck != 0) {
                requestPermissions(
                    arrayOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    ), 1001
                ) //Any number
            }
        } else {
            Log.d(
                ContentValues.TAG,
                "checkBTPermissions: No need to check permissions. SDK version < LOLLIPOP."
            )
        }
    }

    fun initBinding(){
        binding.apply {
            tvJmlPrinter.text = mListPrinter.size.toString()+" perangkat yang terhubung"
            findPrinterAdapter = FindPrinterAdapter(mListPrinter, mListener = object: FindPrinterAdapter.PilihBluetoothPrinterI{
                override fun OnItemClick(element: ListPrinter) {
                    BeePreferenceManager.saveToPreferences(
                        requireContext(),
                        getString(R.string.pref_name_printer),
                        element.namaPrinter
                    )
                    BeePreferenceManager.saveToPreferences(
                        requireContext(),
                        getString(R.string.pref_address_printer),
                        element.address
                    )
                    val action = ListPrinterFragmentDirections.actionListPrinterFragmentToAddPrinterFragment(true, null)
                    findNavController().navigate(action)
                }

            })
            rvListPrinter.layoutManager = LinearLayoutManager(requireContext())
            rvListPrinter.adapter = findPrinterAdapter
        }
    }

    private val receiver = object : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            val action = intent.action
            Log.d(ContentValues.TAG, "onReceive: ACTION FOUND.")
            if (BluetoothDevice.ACTION_FOUND.equals(action)){
                val device: BluetoothDevice? = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
                //                mNewDevicesArrayAdapter.add(device.getName());
                if (device?.getBondState() != BluetoothDevice.BOND_BONDED){
                    if (device?.name != null){
                        mListPrinter.add(ListPrinter(device.name, device!!.address))
                        initBinding()
                    }
//                    findPrinterAdapter.generate(mListPrinter)
                    Log.d(ContentValues.TAG,"onReceive device: " + device?.name + ": "
                            + device!!.address+" "+device+"List find: "+mListPrinter)
                }
            }else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)){
                Log.d(ContentValues.TAG,"onReceive device: discovery is finish")
                stopDiscovery()
            }
//            if (BluetoothDevice.ACTION_FOUND.equals(action)){
//                val device: BluetoothDevice? =
//                    intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
//                if (mListPrinter.isEmpty()){
//                    mListPrinter.add(ListPrinter(device!!.name, device.address))
//                }else{
//                    var isNew = true
//                    for (i in mListPrinter.indices) {
//                        val listDeviceNew: Array<String> =
//                            arrayOf(mListPrinter.get(i).toString())
//                        if (listDeviceNew[1] == device!!.address) {
//                            isNew = false
//                            break
//                        }
//                    }
//                    if (isNew){
//                        mListPrinter.add(ListPrinter(device!!.name, device.address))
//                    }
//                }
//                Log.i("BT Scanning", """${device!!.name}${device.address}""".trimIndent())
//            }
//            if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)){
//                stopDiscovery()
//            }
        }
    }

    private val receiver2 = object: BroadcastReceiver() {
        override fun onReceive(ctx: Context, intent: Intent) {
            val action = intent.action
            if (action.equals(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED)){
                val mode = intent.getIntExtra(BluetoothAdapter.EXTRA_SCAN_MODE, BluetoothAdapter.ERROR)
                when(mode){
                    BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE ->{
                        Log.d(ContentValues.TAG, "receiver2: Discoverability Enabled.")
                    }
                    BluetoothAdapter.SCAN_MODE_CONNECTABLE ->{
                        Log.d(ContentValues.TAG, "receiver2: Able to receive connections.")
                    }
                    BluetoothAdapter.SCAN_MODE_NONE ->{
                        Log.d(ContentValues.TAG, "receiver2: Not able to receive connections")
                    }
                    BluetoothAdapter.STATE_CONNECTING ->{
                        Log.d(ContentValues.TAG, "receiver2: Connecting")
                    }
                    BluetoothAdapter.STATE_CONNECTED ->{
                        Log.d(ContentValues.TAG, "receiver2: Connecting")
                    }
                }
            }
        }

    }

//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == 2 && grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//            Toast.makeText(requireContext(), "bluetooth permission granted", Toast.LENGTH_LONG)
//                .show()
//        }
//    }

    override fun onDestroy() {
        super.onDestroy()
        requireContext().unregisterReceiver(receiver2)
//        requireContext().unregisterReceiver(BluetoothHandlerReceiver.instance)
    }
}