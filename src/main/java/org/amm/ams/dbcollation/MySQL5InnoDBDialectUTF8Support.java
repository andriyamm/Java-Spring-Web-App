package org.amm.ams.dbcollation;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * 
 *
 */
public class MySQL5InnoDBDialectUTF8Support extends MySQL5InnoDBDialect {

	public String getTableTypeString() {
		return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
	}
}
