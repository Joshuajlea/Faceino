package com.FDMGroup.Services;

import com.FDMGroup.Entities.User;

/***
 * 
 * @author martin.mrowiec
 *
 */
public interface LoginDataService {
	User getUserDataFromDatabaseByName(String name);
}
