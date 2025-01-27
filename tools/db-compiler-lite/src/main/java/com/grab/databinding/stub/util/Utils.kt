/*
 * Copyright 2021 Grabtaxi Holdings PTE LTE (GRAB)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.grab.databinding.stub.util

import com.squareup.javapoet.TypeName
import com.grab.databinding.stub.rclass.parser.XmlTypeValues

fun String.extractPrimitiveType(): TypeName? = when (this) {
    "void" -> TypeName.VOID
    "boolean" -> TypeName.BOOLEAN
    "byte" -> TypeName.BYTE
    "short" -> TypeName.SHORT
    "int" -> TypeName.INT
    "long" -> TypeName.LONG
    "char" -> TypeName.CHAR
    "float" -> TypeName.FLOAT
    "double" -> TypeName.DOUBLE
    else -> null
}

/**
 * Convert a layout name in `layout_name` format to Databinding generated type i.e `LayoutNameBinding`
 */
fun String.toLayoutBindingName(): String {
    return split("_")
        .joinToString(
            separator = "",
            transform = String::capitalize
        ) + "Binding"
}

fun enumTypeValue(name: String): XmlTypeValues {
    return enumValues<XmlTypeValues>().first { it.entry == name }
}