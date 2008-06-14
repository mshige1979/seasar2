/*
 * Copyright 2004-2008 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.extension.jdbc.gen;

import org.seasar.extension.jdbc.gen.model.EntityConditionBaseModel;
import org.seasar.extension.jdbc.gen.model.EntityDesc;

/**
 * {@link EntityConditionBaseModel}のファクトリです。
 * 
 * @author taedium
 */
public interface EntityConditionBaseModelFactory {

    /**
     * エンティティ条件基底クラスのモデルを返します。
     * 
     * @param entityDesc
     *            エンティティ記述
     * @param className
     *            エンティティ条件基底クラス名
     * @return エンティティ条件基底クラスのモデル
     */
    EntityConditionBaseModel getEntityConditionBaseModel(EntityDesc entityDesc,
            String className);
}
