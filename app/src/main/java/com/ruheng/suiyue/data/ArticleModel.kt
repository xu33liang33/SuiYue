package com.ruheng.suiyue.data

import com.ruheng.suiyue.data.bean.IdListBean
import com.ruheng.suiyue.data.bean.OneListBean
import com.ruheng.suiyue.network.Api
import com.ruheng.suiyue.network.Callback
import com.ruheng.suiyue.network.OkhttpUtil

/**
 * Created by lvruheng on 2018/3/5.
 */
class ArticleModel(okhttpUtil: OkhttpUtil) {
    var mOkhttpUtil: OkhttpUtil = okhttpUtil
    //获取最新 idlist, 以获取今日或往日的 onelist 信息
    val IDLIST_URL = "onelist/idlist/?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android"
    //获取 onelist,其中data替换成上面的idlist中的数据，代表最近一周的某一天
    val ONELIST_URL = "onelist/data/0?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android"
    //获取故事详细信息，其中item_id替换成onelist中的item_id值
    val DETAIL_URL = "essay/item_id?channel=wdj&source=summary&source_id=9261&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android"
    //获取评论信息，其中item_id替换成onelist中的item_id值
    val COMMENT_URL = "comment/praiseandtime/essay/item_id/0?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android"

    fun getIdList(callback: Callback<IdListBean>) {
        var url = Api.BASE_ARTICLE_URL + IDLIST_URL
        mOkhttpUtil.getDataAsync(url, callback)
    }

    fun getOneList(data: String, callback: Callback<OneListBean>) {
        val url = Api.BASE_ARTICLE_URL + ONELIST_URL.replace("data", data, false)
        mOkhttpUtil.getDataAsync(url,callback)
    }
}