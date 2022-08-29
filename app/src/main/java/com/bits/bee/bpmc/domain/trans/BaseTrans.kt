package com.bits.bee.bpmc.domain.trans

/**
 * Created by aldi on 18/05/22.
 */
abstract class BaseTrans<M , D> {

    protected var mTblMaster : M? = null
    protected var mTblDetail : MutableList<D> =  mutableListOf()

    abstract fun newTrans()

    abstract fun saveTrans()

    abstract fun voidTrans()

    abstract fun loadTrans(var1 : M)


    open fun getMaster() : M{
        return this.mTblMaster!!
    }

    fun getListDetail() : MutableList<D> {
        return this.mTblDetail
    }

    open fun addDetail(d : D) {
        this.mTblDetail.add(d)
    }

    fun clearDetailTransaction(){
        this.mTblDetail.clear()
    }

}
