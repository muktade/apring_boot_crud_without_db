package com.coltroller.repo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.coltroller.entiry.User;

@Repository
public class UserRepo {

	Set<User> saveUser = new HashSet<User>();

	public Set<User> getAll() {
//		List<User> ul = new ArrayList<User>();
//		User ur = new User(1L, "Me", 23.8);
//		saveUser.add(ur);
		return saveUser;
	}

	public List<User> findById(Long id) {
		List<User> u = new ArrayList<User>();
		User ur = findSengleUser(id);
		u.add(ur);
		return u;
	}

	private User findSengleUser(Long id) {
		return saveUser.stream().filter(e -> {
			return e.getId() == id;
		}).findAny().orElse(null);
	}

	public Set<User> addUser(User u) {
		Long id = (long) saveUser.size();
		u.setId(id + 1);
		saveUser.add(u);
		return saveUser;
	}

	public Set<User> update(Long id, User u) throws Exception {
		User dbUser = findSengleUser(id);
		if (dbUser != null) {
			saveUser.remove(dbUser);
			u.setId(id);
			saveUser.add(u);
		} else {
			throw new Exception("User not found");
		}
		return saveUser;
	}

	public Set<User> deleteById(Long id) {
		saveUser.removeIf(e -> e.getId() == id);
		return saveUser;
	}

}
