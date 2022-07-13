package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.ItemBranchEntity
import com.bits.bee.bpmc.data.data_source.remote.response.ItemBranchResponse
import com.bits.bee.bpmc.domain.model.ItemBranch

/**
 * Created by aldi on 22/04/22.
 */
object ItemBranchDataMapper : BaseMapper<ItemBranchEntity, ItemBranch, ItemBranchResponse.ItemBranchModel>(){

    override fun fromDbToDomain(model: ItemBranchEntity): ItemBranch {
        return ItemBranch(
            model.id,
            model.branchId,
            model.itemId,
        )
    }

    override fun fromDomainToDb(model: ItemBranch): ItemBranchEntity {
        return ItemBranchEntity(
            model.id,
            model.branchId,
            model.itemId,
        )
    }

    override fun fromNetworkToDb(model: ItemBranchResponse.ItemBranchModel): ItemBranchEntity {
        return ItemBranchEntity(
            model.id,
            model.branchId,
            model.itemId,
        )
    }
}