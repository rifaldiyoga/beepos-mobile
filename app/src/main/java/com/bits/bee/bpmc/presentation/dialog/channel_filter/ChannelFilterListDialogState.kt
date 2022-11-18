package com.bits.bee.bpmc.presentation.dialog.channel_filter

import com.bits.bee.bpmc.domain.model.Channel

/**
 * Created by aldi on 24/06/22.
 */
data class ChannelFilterListDialogState(
    var channelList : List<Channel> = mutableListOf(),
    var selectedChannelList : List<Channel> = mutableListOf()
)
