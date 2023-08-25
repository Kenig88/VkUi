package com.kenig.vkui.domain

import com.kenig.vkui.R

data class FeedPost(
    val id: Int = 0,
    val communityName: String = "Moto",
    val publicationDate: String = "12:13",
    val avatarResId: Int = R.drawable.suzuki,
    val contentText: String = "Нет никого, кто любил бы боль саму по себе, кто искал бы её и кто хотел бы иметь её просто потому, что это боль..",
    val contentImageResId: Int = R.drawable.gen3,
    val statistics: List<StatisticItem> = listOf(
        StatisticItem(type = StatisticType.VIEWS, 434),
        StatisticItem(type = StatisticType.SHARES, 265),
        StatisticItem(type = StatisticType.COMMENTS, 35),
        StatisticItem(type = StatisticType.LIKES, 287)
    )
)