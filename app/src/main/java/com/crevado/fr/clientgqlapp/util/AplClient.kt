package com.crevado.fr.clientgqlapp.util

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient

import okhttp3.OkHttpClient


class AplClient {
    val BASE_URL = "https://graphql-p534.onrender.com/graphql"
    val TAG = "CLIENT Android APP"
    private var mApolloClient: ApolloClient? = null

    fun getmApolloClient(): ApolloClient? {
        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()

        mApolloClient = ApolloClient.builder()
            .serverUrl(BASE_URL)
            .okHttpClient(okHttpClient)
            .build()

        return mApolloClient
    }
}