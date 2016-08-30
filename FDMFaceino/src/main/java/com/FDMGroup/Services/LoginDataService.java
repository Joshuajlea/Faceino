package com.FDMGroup.Services;

import tempFiles.*;

/***
 * 
 * @author martin.mrowiec
 *
 */
public interface LoginDataService {
	User getUserDataFromDatabaseByName(String name);
}
