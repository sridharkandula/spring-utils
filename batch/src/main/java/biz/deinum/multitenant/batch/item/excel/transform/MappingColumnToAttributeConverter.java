/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */package biz.deinum.multitenant.batch.item.excel.transform;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.Map;

/** 
 * {@link ColumnToAttributeConverter} which maps the names to columns and vice versa based on the provide mapping
 * configuration. If a mapping cannot be found it returns the name as is.
 * 
 * @author Marten Deinum
 */
public class MappingColumnToAttributeConverter implements ColumnToAttributeConverter {

    private final BiMap<String, String> mapping = HashBiMap.create();

    public String toAttribute(final String column) {
        if (this.mapping.containsKey(column)) {
            return this.mapping.get(column);
        }
        return column;
    }

    public String toColumn(final String attribute) {
        if (this.mapping.containsValue(attribute)) {
            return this.mapping.inverse().get(attribute);
        }
        return attribute;
    }

    public void setMappings(final Map<String, String> mappings) {
        this.mapping.clear();
        this.mapping.putAll(mappings);
    }
}
