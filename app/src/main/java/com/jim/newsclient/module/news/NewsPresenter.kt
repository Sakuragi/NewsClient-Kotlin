package com.jim.newsclient.module.news

import com.jim.newsclient.base.BaseCommand
import com.jim.newsclient.base.BasePresenter
import com.jim.newsclient.common.utils.RetrofitUtils
import com.jim.newsclient.config.Constant
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.schedulers.Schedulers

/**
 * Created by Jim on 2017/12/3.
 */
class NewsPresenter(val view:INewsView):BasePresenter(){
    fun fetchNew(newType:Int,page:Int,num:Int){
        val cmd=NewsCommand(page,num)
        when(newType){
            Constant.TYPE_WORLD ->fetchWorldNews(cmd)
            Constant.TYPE_HUABIAN->fetchHuaBian(cmd)
            Constant.TYPE_JIANKANG->fetchHealth(cmd)
            Constant.TYPE_KEJI->fetchKeji(cmd)
            Constant.TYPE_QIWEN->fetchQiwen(cmd)
            Constant.TYPE_TIYU->fetchTiYu(cmd)
            Constant.TYPE_TRAVEL->fetchTravel(cmd)
        }
    }
    private fun fetchWorldNews(cmd: BaseCommand){
        RetrofitUtils.fetchWorldNews(cmd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(Action1 { resp->view.onNewsFetched(resp) }, Action1 { t ->view.onNewsFetchedFailed(t)    })

    }

    private fun fetchTravel(cmd: BaseCommand){
        RetrofitUtils.fetchTravel(cmd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(Action1 { resp->view.onNewsFetched(resp) }, Action1 { t ->view.onNewsFetchedFailed(t)    })

    }

    private fun fetchTiYu(cmd: BaseCommand){
        RetrofitUtils.fetchTiYu(cmd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(Action1 { resp->view.onNewsFetched(resp) }, Action1 { t ->view.onNewsFetchedFailed(t)    })

    }

    private fun fetchQiwen(cmd: BaseCommand){
        RetrofitUtils.fetchQiwen(cmd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(Action1 { resp->view.onNewsFetched(resp) }, Action1 { t ->view.onNewsFetchedFailed(t)    })

    }

    private fun fetchKeji(cmd: BaseCommand){
        RetrofitUtils.fetchKeji(cmd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(Action1 { resp->view.onNewsFetched(resp) }, Action1 { t ->view.onNewsFetchedFailed(t)    })

    }

    private fun fetchHuaBian(cmd: BaseCommand){
        RetrofitUtils.fetchHuaBian(cmd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(Action1 { resp->view.onNewsFetched(resp) }, Action1 { t ->view.onNewsFetchedFailed(t)    })

    }

    private fun fetchHealth(cmd: BaseCommand){
        RetrofitUtils.fetchHealth(cmd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(Action1 { resp->view.onNewsFetched(resp) }, Action1 { t ->view.onNewsFetchedFailed(t)    })

    }
}