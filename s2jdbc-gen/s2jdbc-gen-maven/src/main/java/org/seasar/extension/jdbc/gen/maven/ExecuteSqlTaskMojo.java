/*
 * Copyright 2004-2009 the Seasar Foundation and the Others.
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
package org.seasar.extension.jdbc.gen.maven;

import java.io.File;
import java.util.Arrays;

import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.extension.jdbc.gen.command.Command;
import org.seasar.extension.jdbc.gen.dialect.GenDialect;
import org.seasar.extension.jdbc.gen.internal.command.ExecuteSqlCommand;
import org.seasar.extension.jdbc.gen.internal.factory.Factory;

/**
 * @goal exec-sql-task
 */
public class ExecuteSqlTaskMojo extends AbstractS2JdbcGenMojo {

	/** コマンド */
	protected ExecuteSqlCommand command = new ExecuteSqlCommand();

	/**
	 * 設定ファイルのパスを設定します。
	 * 
	 * @parameter
	 */
	private String configPath;

	/**
	 * 環境名を設定します。
	 * 
	 * @parameter
	 */
	private String env;

	/**
	 * {@link JdbcManager}のコンポーネント名を設定します。
	 * 
	 * @parameter
	 */
	private String jdbcManagerName;

	/**
	 * {@link Factory}の実装クラス名を設定します。
	 * 
	 * @parameter
	 */
	private String factoryClassName;

	 /**
	 * すでに値が設定された{@link FileList}を追加します。
	 * 
	 * @parameter
	 */
	private File[] sqlFiles; // List<File>はMavenでエラーになるので

	/**
	 * SQLブロックの区切り文字を設定します。
	 * 
	 * @parameter
	 */
	private String blockDelimiter;

	/**
	 * SQLステートメントの区切り文字を設定します。
	 * 
	 * @parameter
	 */
	private Character statementDelimiter;

	/**
	 * エラー発生時に処理を中止する場合{@code true}を設定します。
	 * 
	 * @parameter
	 */
	private Boolean haltOnError;

	/**
	 * SQLファイルのエンコーディングを設定します。
	 * 
	 * @parameter
	 */
	private String sqlFileEncoding;

	/**
	 * すべてのSQLを単一のトランザクションで実行する場合{@code true}、そうでない場合{@code false}を設定します。
	 * 
	 * @parameter
	 */
	private Boolean transactional;

	/**
	 * {@link GenDialect}の実装クラス名を設定します。
	 * 
	 * @parameter
	 */
	private String genDialectClassName;

	@Override
	protected Command getCommand() {
		return command;
	}

	@Override
	protected void doExecute() {
		if (configPath != null)
			command.setConfigPath(configPath);
		if (env != null)
			command.setEnv(env);
		if (jdbcManagerName != null)
			command.setJdbcManagerName(jdbcManagerName);
		if (factoryClassName != null)
			command.setFactoryClassName(factoryClassName);
		if (sqlFiles != null)
			command.getSqlFileList().addAll(Arrays.asList(sqlFiles));
		if (blockDelimiter != null)
			command.setBlockDelimiter(blockDelimiter);
		if (statementDelimiter != null)
			command.setStatementDelimiter(statementDelimiter);
		if (haltOnError != null)
			command.setHaltOnError(haltOnError);
		if (sqlFileEncoding != null)
			command.setSqlFileEncoding(sqlFileEncoding);
		if (transactional != null)
			command.setTransactional(transactional);
		if (genDialectClassName != null)
			command.setGenDialectClassName(genDialectClassName);
	}
}
