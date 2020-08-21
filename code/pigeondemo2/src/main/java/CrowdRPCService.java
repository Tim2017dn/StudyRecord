import java.util.List;

public interface CrowdRPCService {
    List<CrowdInfoRPC> listCrowd(String misId, int mine, int scope);
}
