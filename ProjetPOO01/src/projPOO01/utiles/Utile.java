package projPOO01.utiles;

public class Utile {
	
	public static <T> T mTemplate(Class<T> maclasse) throws InstantiationException, IllegalAccessException
	{
		T t;
		t = maclasse.newInstance();
		
		return  t;
	}
}
