package Entity;

public class PackageDetails {
    private int packageId;
    private String status;

    public PackageDetails(int packageId, String status) {
        this.packageId = packageId;
        this.status = status;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PackageDetails{" +
                "packageId=" + packageId +
                ", status='" + status + '\'' +
                '}';
    }
}
