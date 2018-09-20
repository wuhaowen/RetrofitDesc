# RetrofitDesc
为retrofit 接口声明添加描述信息，用于打印调试或者文件日志
   
# 使用

为retrofit接口添加DESC注解，写明接口描述   

    @DESC("激活")
    @FormUrlEncoded
    @POST("url.........")
    fun activate(@Field("name") name: String, @Field("password") password: String): Observable<Activation>

retrofit添加ApiDescCallAdapterFactory，回调中可以获取到desc

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, factory: GsonConverterFactory) = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addCallAdapterFactory(ApiDescCallAdapterFactory.create {
                Log.d("api-desc",it)
            })
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(factory)
            .build()
