package com.github.banchaproject.banchalibrary.infra.config

import org.mapstruct.MapperConfig

@MapperConfig(
    // 生成されたMapperに@Singletonをつける
    componentModel = "jsr330")
interface MapConfig