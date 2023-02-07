package com.bits.bee.bpmc.domain.usecase.setting.favorit

import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.repository.ItemRepository
import com.bits.bee.bpmc.domain.repository.VariantRepository
import javax.inject.Inject

/**
 * Created by aldi on 06/10/22
 */
class UpdateFavProdukUseCase @Inject constructor(
    private val itemRepository: ItemRepository,
    private val variantRepository: VariantRepository
) {

    suspend operator fun invoke(item : Item) {
        if(!item.isVariant) {
            item.isFavorit = !item.isFavorit
            itemRepository.addUpdateItem(item)
        } else {
            variantRepository.updateFavorit(item.id, !item.isFavorit)
        }
    }

}