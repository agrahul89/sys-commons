package domain.brandname.syscode.commons.utilities;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public final class ResourceUtility {

	private static final Logger LOGGER = LogManager.getLogger(ResourceUtility.class);

	private ResourceUtility() {
		super();
	}

	public static final void close(Closeable... resources) {
		if (resources != null && resources.length > 0) {
			IOUtils.closeQuietly(resources);
		}
	}

	public static final void close(ResultSet... resultSets) {
		if (resultSets != null && resultSets.length > 0) {
			for (ResultSet resultSet : resultSets) {
				try {
					resultSet.close();
				} catch (final SQLException ex) {
					LOGGER.info(ex.getMessage());
				}
			}
		}
	}

	public static final void close(Statement... statements) {
		if (ArrayUtils.isNotEmpty(statements)) {
			for (Statement statement : statements) {
				try {
					statement.close();
				} catch (final SQLException ex) {
					LOGGER.info(ex.getMessage());
				}
			}
		}
	}

	public static final void flush(Flushable... resources) {
		if (ArrayUtils.isNotEmpty(resources)) {
			for (Flushable resource : resources) {
				try {
					resource.flush();
				} catch (IOException ex) {
					LOGGER.info(ex.getMessage());
				}
			}
		}
	}

}
