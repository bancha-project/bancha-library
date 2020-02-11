package com.github.banchaproject.banchalibrary.infra.aws

import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties(RdsConfig.PREFIX)
class RdsConfig {
    companion object {
        const val PREFIX = "aws.rds"
    }

    var url: String = ""
    var region: String = ""
    var database: String = ""
    var resourceArn: String = ""
    var secretArn: String = ""
}