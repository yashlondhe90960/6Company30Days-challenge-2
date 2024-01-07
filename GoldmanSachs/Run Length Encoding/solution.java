


class Solve {
    String encode(String str)
	{
          //Your code here
          
          if(str ==null || str.isEmpty()){
              return "";
              
          }
          
          StringBuilder sc = new StringBuilder();
          int cnt = 1;
          char currChar = str.charAt(0);
          
          
          for(int i=1;i<str.length(); i++)
          {
              if(str.charAt(i) == currChar){
                  cnt++;
              } else {
                  sc.append(currChar).append(cnt);
                  cnt=1;
                  currChar = str.charAt(i);
                  
              }
          }
          sc.append(currChar).append(cnt);
          return sc.toString();
          
	}
}