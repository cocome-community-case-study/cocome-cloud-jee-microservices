package cocome.cloud.sa.query;

// TODO this is super strange stuff. Why are there strings declared in an interface which is
// not an interface (as it has no methods).
// should this be an enumertion
public interface IQueryConst {

	String QUERY_INSERT = "query.insert";
	String QUERY_UPDATE = "query.update";
	String QUERY_SELECT = "query.select";
	String QUERY_DELETE = "query.delete";

	// String INSERT_ENTERPRISE = "enterprise";
	// String INSERT_STORE = "store";
	// String INSERT_PRODUCT = "product";

	String CMD_ALL = "*";
	String DELIMITER_PARAMETER_VALUES = "=";
	String DELIMITER_PARAMETER = ",";

	String ENTITY_TYPE = "entity.type";
}
