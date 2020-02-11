package com.github.banchaproject.banchalibrary.infra.aws

import com.amazon.rdsdata.client.RdsDataClient
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.rdsdata.AWSRDSDataClient
import io.micronaut.context.annotation.Factory
import io.micronaut.context.annotation.Value
import javax.inject.Singleton

@Factory
class RdsDataClientFactory(
    private val rdsConfig: RdsConfig
) {
    @Value("\${aws.accessKeyId}")
    private var accessKeyId: String = ""

    @Value("\${aws.secretKeyId}")
    private var secretKeyId: String = ""

    @Singleton
    fun rdsDataClient(): RdsDataClient {
        val credentialsProvider = AWSStaticCredentialsProvider(BasicAWSCredentials(accessKeyId, secretKeyId))
        val rdsData = AWSRDSDataClient.builder()
            .withCredentials(credentialsProvider)
            .withEndpointConfiguration(AwsClientBuilder.EndpointConfiguration(rdsConfig.url, rdsConfig.region)).build()
        return RdsDataClient.builder()
            .rdsDataService(rdsData)
            .database(rdsConfig.database)
            .resourceArn(rdsConfig.resourceArn)
            .secretArn(rdsConfig.secretArn)
            .build()
    }
}