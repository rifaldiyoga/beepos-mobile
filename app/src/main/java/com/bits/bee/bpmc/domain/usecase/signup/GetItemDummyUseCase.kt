package com.bits.bee.bpmc.domain.usecase.signup

import com.bits.bee.bpmc.domain.model.ItemDummy
import com.bits.bee.bpmc.domain.repository.ItemDummyRepository
import com.bits.bee.bpmc.domain.repository.UnitDummyRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * Created by aldi on 31/08/22.
 */
class GetItemDummyUseCase @Inject constructor(
    private val itemDummyRepository: ItemDummyRepository,
    private val unitDummyRepository: UnitDummyRepository,
    private val defDispatcher : CoroutineDispatcher
) {

    operator fun invoke() : Flow<Resource<List<ItemDummy>>> = flow {
        emit(Resource.loading())
        val itemList = itemDummyRepository.getItemDummyList().first().map {
            it.unitList = unitDummyRepository.getUnitByItemId(it.id!!).first()
            it
        }
        emit(Resource.success(itemList))
    }.flowOn(defDispatcher)

}