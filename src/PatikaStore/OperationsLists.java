package PatikaStore;

public class OperationsLists {
    private int operationId;
    private String operationName;

    public OperationsLists(int operationId, String operationName) {
        this.operationId = operationId;
        this.operationName = operationName;
    }

    public int getOperationId() {
        return operationId;
    }

    public String getOperationName() {
        return operationName;
    }
}
