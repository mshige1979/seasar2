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

import java.io.File;

/**
 * ダンプデータをロードするインタフェースです。
 * 
 * @author taedium
 */
public interface Loader {

    /**
     * ロードします。
     * 
     * @param sqlExecutionContext
     *            SQL実行コンテキスト
     * @param databaseDesc
     *            データベース記述
     * @param dumpFile
     *            ダンプファイル
     */
    void load(SqlExecutionContext sqlExecutionContext,
            DatabaseDesc databaseDesc, File dumpFile);

    /**
     * ダンプファイルの場合{@code true}を返します。
     * 
     * @param file
     *            ファイル
     * @return ダンプファイルの場合{@code true}
     */
    boolean isTarget(File file);
}