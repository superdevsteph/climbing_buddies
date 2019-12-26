package fr.ocr.climbing.dao;

import java.util.List;

import fr.ocr.climbing.entity.User;
import fr.ocr.climbing.model.UserInfo;

public interface UserDAO {

	public User findUser(Long id);

	public List<UserInfo> listUserInfos();

	public void saveUser(UserInfo userInfo);

	public UserInfo findUserInfo(Long id);

	public void deleteUser(Long id);
	
	
}