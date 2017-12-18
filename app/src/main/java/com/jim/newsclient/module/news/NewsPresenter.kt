package com.jim.newsclient.module.news

import com.jim.newsclient.base.BaseCommand
import com.jim.newsclient.base.BasePresenter
import com.jim.newsclient.common.utils.RetrofitUtils
import com.jim.newsclient.config.Constant
import com.jim.newsclient.module.news.model.NewsCommand
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Jim on 2017/12/3.
 */
class NewsPresenter(val view:INewsView):BasePresenter(){
    fun fetchNews(newType:Int,page:Int,num:Int){
        val cmd= NewsCommand(page,num)
        fetchNewsReal(Constant.URLS[newType],cmd)
//        when(newType){
//            Constant.TYPE_WORLD ->fetchWorldNews(cmd)
//            Constant.TYPE_HUABIAN->fetchHuaBian(cmd)
//            Constant.TYPE_JIANKANG->fetchHealth(cmd)
//            Constant.TYPE_KEJI->fetchKeji(cmd)
//            Constant.TYPE_QIWEN->fetchQiwen(cmd)
//            Constant.TYPE_TIYU->fetchTiYu(cmd)
//            Constant.TYPE_TRAVEL->fetchTravel(cmd)
//        }
    }

    fun fetchNewsReal(path:String,cmd: BaseCommand){
        RetrofitUtils.fetchNews(path,cmd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ resp->view.onNewsFetched(resp) },{t ->view.onNewsFetchedFailed(t)})
    }

    fun fetchWorldNews(cmd: BaseCommand) {
        RetrofitUtils.fetchWorldNews(cmd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ resp -> view.onNewsFetched(resp) }, { t -> view.onNewsFetchedFailed(t) })
    }


    fun fetchTravel(cmd: BaseCommand){
        RetrofitUtils.fetchTravel(cmd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ resp->view.onNewsFetched(resp) },{t ->view.onNewsFetchedFailed(t)})

    }

    fun fetchTiYu(cmd: BaseCommand){
        RetrofitUtils.fetchTiYu(cmd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ resp->view.onNewsFetched(resp) },{t ->view.onNewsFetchedFailed(t)})

    }

    fun fetchQiwen(cmd: BaseCommand){
        RetrofitUtils.fetchQiwen(cmd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ resp->view.onNewsFetched(resp) },{t ->view.onNewsFetchedFailed(t)})
    }

    fun fetchKeji(cmd: BaseCommand){
        RetrofitUtils.fetchKeji(cmd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ resp->view.onNewsFetched(resp) },{t ->view.onNewsFetchedFailed(t)})

    }

    fun fetchHuaBian(cmd: BaseCommand){
        RetrofitUtils.fetchHuaBian(cmd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ resp->view.onNewsFetched(resp) },{t ->view.onNewsFetchedFailed(t)})

    }

    fun fetchHealth(cmd: BaseCommand){
        RetrofitUtils.fetchHealth(cmd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ resp->view.onNewsFetched(resp) },{t ->view.onNewsFetchedFailed(t)})

    }
}