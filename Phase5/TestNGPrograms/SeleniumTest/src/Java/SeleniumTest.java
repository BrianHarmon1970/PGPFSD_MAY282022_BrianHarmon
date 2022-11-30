
class SeleniumTest
{
	public static void main( String[] Args)
	{
		//	String titleTagContent = driver.getTitle();
//	String pageContent	= driver.getPageSource();
//	System.out.println(url);
//	System.out.println(titleTagContent);
//	System.out.println(pageContent);
//	WebElement h2TagRef	 = driver.findElement(By.tagName("h2"));
//	WebElement pTagRef	 = driver.findElement(By.tagName("p"));
//	WebElement divTagRef	 = driver.findElement(By.tagName("div"));
//	WebElement bTagRef	 = driver.findElement(By.tagName("b"));
//	System.out.println(h2TagRef.getTagName()+" "+h2TagRef.getText());
//	System.out.println(pTagRef.getTagName()+" "+pTagRef.getText());
//	System.out.println(divTagRef.getTagName()+" "+divTagRef.getText());
//	System.out.println(bTagRef.getTagName()+" "+bTagRef.getText());

//	WebElement pTagRef	 = driver.findElement(By.tagName("p"));
//	WebElement pTagRefId1 = driver.findElement(By.id("p1"));
//	WebElement pTagRefId2 = driver.findElement(By.id("p2"));
//	System.out.println(pTagRef.getTagName()+" "+pTagRef.getText());
//	System.out.println(pTagRefId1.getTagName()+" "+pTagRefId1.getText());
//	System.out.println(pTagRefId2.getTagName()+" "+pTagRefId2.getText());

		List<WebElement> ll = driver.findElements(By.tagName("p"));
		Iterator<WebElement> li = ll.iterator();
		while(li.hasNext()) {
			WebElement pRef = li.next();
			System.out.println(pRef.getTagName()+" "+pRef.getText());
		}
	}

}
}