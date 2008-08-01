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
package org.seasar.extension.jdbc.gen.dialect;

import java.math.BigDecimal;
import java.sql.Types;

import javax.persistence.GenerationType;
import javax.persistence.TemporalType;

/**
 * H2の方言を扱うクラスです。
 * 
 * @author taedium
 */
public class H2GenDialect extends StandardGenDialect {

    /** テーブルが見つからないことを示すエラーコード */
    protected static int TABLE_NOT_FOUND_ERROR_CODE = 42101;

    /**
     * インスタンスを構築します。
     */
    public H2GenDialect() {
        sqlTypeMap.put(Types.BINARY, H2SqlType.BINARY);
        sqlTypeMap.put(Types.DECIMAL, H2SqlType.DECIMAL);

        columnTypeMap.put("binary", H2ColumnType.BINARY);
        columnTypeMap.put("decimal", H2ColumnType.DECIMAL);
    }

    @Override
    public String getDefaultSchemaName(String userName) {
        return null;
    }

    @Override
    public GenerationType getDefaultGenerationType() {
        return GenerationType.IDENTITY;
    }

    @Override
    public boolean supportsSequence() {
        return true;
    }

    @Override
    public String getSequenceDefinitionFragment(String dataType, int initValue,
            int allocationSize) {
        return "start with " + allocationSize + " increment by " + initValue;
    }

    @Override
    public String getIdentityColumnDefinition() {
        return "generated by default as identity";
    }

    @Override
    public boolean isTableNotFound(Throwable throwable) {
        Integer errorCode = getErrorCode(throwable);
        return errorCode != null
                && errorCode.intValue() == TABLE_NOT_FOUND_ERROR_CODE;
    }

    /**
     * H2用の{@link SqlType}の実装です。
     * 
     * @author taedium
     */
    public static class H2SqlType extends StandardSqlType {

        private static H2SqlType BINARY = new H2SqlType("binary($l)");

        private static H2SqlType DECIMAL = new H2SqlType("decimal($p,$s)");

        /**
         * インスタンスを構築します。
         * 
         * @param columnDefinition
         *            カラム定義
         */
        protected H2SqlType(String columnDefinition) {
            super(columnDefinition);
        }
    }

    /**
     * H2用の{@link ColumType}の実装です。
     * 
     * @author taedium
     */
    public static class H2ColumnType extends StandardColumnType {

        private static H2ColumnType BINARY = new H2ColumnType("binary($l)",
                byte[].class);

        private static H2ColumnType DECIMAL = new H2ColumnType(
                "decimal($p,$s)", BigDecimal.class);

        /**
         * インスタンスを構築します。
         * 
         * @param columnDefinition
         *            カラム定義
         * @param attributeClass
         *            属性のクラス
         */
        public H2ColumnType(String columnDefinition, Class<?> attributeClass) {
            super(columnDefinition, attributeClass);
        }

        /**
         * インスタンスを構築します。
         * 
         * @param columnDefinition
         *            カラム定義
         * @param attributeClass
         *            属性のクラス
         * @param lob
         *            LOBの場合{@code true}
         */
        public H2ColumnType(String columnDefinition, Class<?> attributeClass,
                boolean lob) {
            super(columnDefinition, attributeClass, lob);
        }

        /**
         * インスタンスを構築します。
         * 
         * @param columnDefinition
         *            カラム定義
         * @param attributeClass
         *            属性のクラス
         * @param temporalType
         *            時制型
         */
        public H2ColumnType(String columnDefinition, Class<?> attributeClass,
                TemporalType temporalType) {
            super(columnDefinition, attributeClass, temporalType);
        }
    }
}
