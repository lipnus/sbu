package com.empo.android.empoapp.repository


import android.util.Log
import com.empo.android.empoapp.retro.factory.NullOnEmptyConverterFactory
import com.lipnus.sbu.R
import com.lipnus.sbu.model.EmptyResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

/**
 * [참고자료] https://medium.com/@elye.project/kotlin-and-retrofit-2-tutorial-with-working-codes-333a4422a890
 *
 * 이 앱은 현재 서버가 없음. 추후에 서버를 만들고 싶으면 요 Retrofit을 이용
 *
 */

//호출은 이런식으로

//apiService.pussy("이름", "나이")
//.subscribeOn(Schedulers.io())
//.observeOn(AndroidSchedulers.mainThread())
//.subscribe(
//{ result ->
//    // 결과
//},
//{ error ->
//    //에러
//    }
//}

interface ApiService {


    //API함수(예시)
    @POST("pussy")
    fun member_join (@Query("name") name: String,
                     @Query("age") age: String): Observable<EmptyResponse>



    companion object {

        fun create(): ApiService {

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("서버주소")
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}
