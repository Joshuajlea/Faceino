package com.FDMGroup.Services;

import tempFiles.User;

/***
 * 
 * @author martin.mrowiec
 *
 */
public interface LoginDataService {
	User getUserDataFromDatabaseByName(String name);
}
