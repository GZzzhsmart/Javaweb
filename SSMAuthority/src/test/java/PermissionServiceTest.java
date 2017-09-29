import com.gs.bean.Permission;
import com.gs.service.PermissionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

public class PermissionServiceTest extends BaseTest {
    @Autowired
    private PermissionService permissionService;

    @Test
    public void testGetByPermissionRole() {
        List<Integer> roleIds = new ArrayList<Integer>();
        roleIds.add(1);
        Permission permission = permissionService.getByPermissionRole(roleIds, "com.gs.controller.UserController.menu2");
        System.out.println(permission);
    }


}
