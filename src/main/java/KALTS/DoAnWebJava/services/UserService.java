package KALTS.DoAnWebJava.services;

import KALTS.DoAnWebJava.entity.User;
import KALTS.DoAnWebJava.repository.IRoleRepository;
import KALTS.DoAnWebJava.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;
    public void save(User user){
        userRepository.save(user);
        Long userId = userRepository.getUserIdByUserName(user.getUsername());
        Long roleId = roleRepository.getRoleIdByName("USER");
        if(roleId !=0 && userId != 0){
            userRepository.addRoleToUser(userId, roleId);
        }
    }
}
