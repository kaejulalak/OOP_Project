import java.util.Scanner;
class store{
	static Scanner sc = new Scanner(System.in);//charactor
	static Scanner sn = new Scanner(System.in);//integer
	static String check,input,t="correct",f="wrong";
	//position of flower in array
	//							0			1            2             3           4           5            6              7            8
	static String flower[]={"RED ROSE","WHITE ROSE","BLACK ROSE","ORANGE LILY","RED LILY","WHITE LILY","YELLOW TULIP","RED TULIP","ORANGE TULIP"};
	static int pricestock[][]={{15,20,25,25,35,30,25,30,30},{100,50,50,50,50,50,55,55,30}};//[price][stock]
	static int fixed[]={100,50,50,50,50,50,55,55,30};
	public static String checkinput(String iuser,String ipass){
		check=t;String u1="nantipat" ,p1="010" ,u2="admin" ,p2="000",cl="close";
		if(iuser.equals(u1)&&ipass.equals(p1)){
			System.out.println("________________\"WELCOME\"_______________\nNantipat Suwanvong\n\n6030213010\n");
		}else if(iuser.equals(u2)&&ipass.equals(p2)){
			System.out.println("________________\"WELCOME\"_______________\nAdmin Power\n\nnone.\n\nnone.");
		}else if(iuser.equals(cl)&&ipass.equals(cl)){
			System.out.println("--------------Close--------------");check=cl;
		}else{
			System.out.println("\"fail :wrong username or password\"");
			check = f;
		}
		return check;
	}
	public static String checkinbundle(String inputchore){
		check=t;
		switch(inputchore){
			case"0":check="back";break;
			case "1":case "2":case"3":case"4":case"5":case"6":case"7":break;
			default:System.out.println("fail :wrong choice Please input again");check=f;
		}
		return check;
	}
	void checkstock(){
		for(int count=0;count<9;count++){
			if(pricestock[1][count]<=5&&pricestock[1][count]>0){
				System.out.println("--------------------------------------------------------------------");
				System.out.println("Notice ! "+flower[count]+" in stock "+pricestock[1][count]);
			}
		}
	}
	public static void checkstock2(){
		System.out.println("               <Check Stock>");
		for(int p=0;p<flower.length;p++){
			System.out.println(flower[p]+" sold "+(fixed[p]-pricestock[1][p])+" in stock ("+pricestock[1][p]+")");
		}
	}
	int stringtoint(String lek,String question){
		Scanner sti =new Scanner(System.in);
		String check2;
		int x,sum=0,digit;
		do{
			x=0;sum=0;digit=1;check2=t;
			for(int i3=lek.length()-1;(i3>=0)&&check2.equals(t);i3--){
				if(lek.charAt(i3)=='0')x=0;
				else if(lek.charAt(i3)=='1')x=1;
				else if(lek.charAt(i3)=='2')x=2;
				else if(lek.charAt(i3)=='3')x=3;
				else if(lek.charAt(i3)=='4')x=4;
				else if(lek.charAt(i3)=='5')x=5;
				else if(lek.charAt(i3)=='6')x=6;
				else if(lek.charAt(i3)=='7')x=7;
				else if(lek.charAt(i3)=='8')x=8;
				else if(lek.charAt(i3)=='9')x=0;
				else check2=f;
				if(check2.equals(t)){
					x*=digit;sum+=x;digit*=10;
				}
			}
			if(check2.equals(f)){
				System.out.println("fail :it is not integer please input again");
				System.out.print(question);lek=sti.nextLine();
			}
		}while(check2.equals(f));
		return sum;
	}
	public static void main(String []args){
		store op=new store();
		String iuser="none",ipass="none",lek,q;
		do{
			check = f;
			while(check.equals(f)&&!check.equals("close")){
				System.out.print("Username ");iuser=sc.nextLine();
				System.out.print("Password ");ipass=sc.nextLine();
				check=checkinput(iuser,ipass);
			}
			if(check.equals(t)){
				int ordertee=1;
				do{
					int j= 0;
					int amount[][]=new int [30][9];
					int c[]=new int[30];
					for(int i=0;i<c.length;i++){
						c[i]=1;
					}
					String chore="none";
					int counting=0;
					System.out.printf("-----------------Order TEE (%d)-------------------\n",ordertee);
					System.out.print("set by us(a) or custom(b) or check stock(c): ");input=sc.nextLine();
					if(input.toLowerCase().equals("a")||input.toLowerCase().equals("b")){
						do{ 
							if(input.toLowerCase().equals("a")){
								chore="none";
								System.out.println("--------------------------------------------------------------------");
								System.out.println("Bundle(1)               Bundle(2)               Bundle(3)");
								System.out.println("    white Rose   x5         black Rose   x5         red Lily	 x5");
								System.out.println("    white Lily   x1         white Rose   x1         orande Tulip x1");
								System.out.println();
								System.out.println("Bundle(4)               Bundle(5)               Bundle(6)");
								System.out.println("    white Rose   x6         white Lily   x6         white Rose   x10"); 
								System.out.println("    red Tulip    x1         yellow Tulip x1         red Lily     x3");
								System.out.println("                                                    yellow Tulip x2");
								System.out.println("Bundle(7)");
								System.out.println("    red rose     x7\n    orange Lily  x5\n    yellow Tulip x3");
								System.out.println("Back(0)");
								System.out.println("--------------------------------------------------------------------");
								do{
									check=t;
									System.out.print("Choose bundle : ");chore=sc.nextLine();
									check=checkinbundle(chore);
								}while(check.equals(f)&&!check.equals("back"));
									if(!chore.equals("0")){
										System.out.print("How many?");lek=sc.nextLine();q="How many?";
										c[counting]=op.stringtoint(lek,q);
										if(c[counting]>0){
											if(chore.equals("1")){
												amount[j][1]=5;amount[j][5]=1;
												if((c[counting]*amount[j][1])<=pricestock[1][1]
												&&(c[counting]*amount[j][5])<=pricestock[1][5]){
													pricestock[1][1]-=amount[j][1]*c[counting];
													pricestock[1][5]-=amount[j][5]*c[counting];
													j++;counting++;
												}else{
													System.out.println("fail :flower not enough");
													amount[j][1]=0;amount[j][5]=0;c[counting]=1;
												}
											}else if(chore.equals("2")){
												amount[j][1]=1;amount[j][2]=5;
												if((c[counting]*amount[j][1])<=pricestock[1][1]
												&&(c[counting]*amount[j][2])<=pricestock[1][2]){
													pricestock[1][1]-=amount[j][1]*c[counting];
													pricestock[1][2]-=amount[j][2]*c[counting];
													j++;counting++;
												}else{
													System.out.println("fail :flower not enough");
													amount[j][1]=0;amount[j][2]=0;c[counting]=1;
												}
											}else if(chore.equals("3")){
												amount[j][4]=5;amount[j][8]=1;
												if((c[counting]*amount[j][4])<=pricestock[1][4]
												&&(c[counting]*amount[j][8])<=pricestock[1][8]){
													pricestock[1][4]-=amount[j][4]*c[counting];
													pricestock[1][8]-=amount[j][8]*c[counting];
													j++;counting++;
												}else{
													System.out.println("fail :flower not enough");
													amount[j][4]=0;amount[j][8]=0;c[counting]=1;
												}
											}else if(chore.equals("4")){
												amount[j][1]=6;amount[j][7]=1;
												if((c[counting]*amount[j][1])<=pricestock[1][1]
												&&(c[counting]*amount[j][7])<=pricestock[1][7]){
													pricestock[1][1]-=amount[j][1]*c[counting];
													pricestock[1][7]-=amount[j][7]*c[counting];
													j++;counting++;
												}else{
													System.out.println("fail :flower not enough");
													amount[j][1]=0;amount[j][7]=0;c[counting]=1;
												}
											}else if(chore.equals("5")){
												amount[j][5]=6;amount[j][6]=1;
												if((c[counting]*amount[j][5])<=pricestock[1][5]
												&&(c[counting]*amount[j][6])<=pricestock[1][6]){
													pricestock[1][5]-=amount[j][5]*c[counting];
													pricestock[1][6]-=amount[j][6]*c[counting];
													j++;counting++;
												}else{
													System.out.println("fail :flower not enough");
													amount[j][5]=0;amount[j][6]=0;c[counting]=1;
												}
											}else if(chore.equals("6")){
												amount[j][1]=10;amount[j][4]=3;amount[j][6]=2;
												if((c[counting]*amount[j][1])<=pricestock[1][1]
												&&(c[counting]*amount[j][4])<=pricestock[1][4]
												&&(c[counting]*amount[j][6])<=pricestock[1][6]){
													pricestock[1][1]-=amount[j][1]*c[counting];
													pricestock[1][4]-=amount[j][4]*c[counting];
													pricestock[1][6]-=amount[j][6]*c[counting];
													j++;counting++;
												}else{
													System.out.println("fail :flower not enough");
													amount[j][1]=0;amount[j][4]=0;amount[j][6]=0;
												}
											}else if(chore.equals("7")){
												amount[j][0]=7;amount[j][3]=5;amount[j][6]=3;
												if((c[counting]*amount[j][1])<=pricestock[1][0]
												&&(c[counting]*amount[j][3])<=pricestock[1][3]
												&&(c[counting]*amount[j][6])<=pricestock[1][6]){
													pricestock[1][0]-=amount[j][0]*c[counting];
													pricestock[1][3]-=amount[j][3]*c[counting];
													pricestock[1][6]-=amount[j][6]*c[counting];
													j++;counting++;
												}else{
													System.out.println("fail :flower not enough");
													amount[j][0]=0;amount[j][3]=0;
													amount[j][6]=0;c[counting]=1;
												}
											}
										}else if(c[counting]<=0)
											System.out.printf("fail :amount of bundle is %d \n",c[counting]);
									}
							}else if(input.toLowerCase().equals("b")){
								do{
									chore="none";int size = 0;
									System.out.println("--------------------------------------------------------------------");
									while(!chore.equals("s")&&!chore.equals("m")&&!chore.equals("l")&&!chore.equals("b")){
										check=f;
										System.out.print("Choose size (S)5 flowers ,(M)10 flowers ,(L)15 flowers < Back(b)> :");
										chore=sc.nextLine();chore.toLowerCase();
										if(chore.equals("s"))
											size = 5;
										else if(chore.equals("m"))
											size = 10;
										else if(chore.equals("l"))
											size = 15;
										else if(chore.equals("b"))
											check=t;
										else 
											System.out.println("fail :wrong size");
									}
									if(!chore.equals("b")){
										while(size>0){
											int item[]=new int[9];
											String type="none";
											op.checkstock();
											while(!type.equals("r")&&!type.equals("l")&&!type.equals("t")&&!type.equals("0")){
												System.out.print("Rose(R)  Lily(L)  Tulip(T) <Back(0)>\nChoose type of flower : ");
												type=sc.nextLine();type.toLowerCase();
												if(!type.equals("r")&&!type.equals("l")&&!type.equals("t")&&!type.equals("0"))
													System.out.println("fail :wrong type");
												else if(type.equals("0"))
													size=-1;
											}
											String color="none";
											System.out.println("--------------------------------------------------------------------");
											if(type.equals("r")){
												while(!color.equals("1")&&!color.equals("2")&&!color.equals("3")&&!color.equals("0")){
													System.out.print("<ROSE>\nRed(1)cost 15 THB   White(2)cost 25 THB   Black(3)cost 25 THB   ");
													System.out.print("<Back(0)>\nColor :");
													color=sc.nextLine();
													if(!color.equals("1")&&!color.equals("2")&&!color.equals("3")&&!color.equals("0"))
														System.out.println("fail :wrong color");
												}
												if(!color.equals("0"))
													System.out.println("You have to input amount <"+size+">");
												if(color.equals("1")){
													System.out.print("amount : ");lek=sc.nextLine();q="amount : ";
													item[0]=op.stringtoint(lek,q);
													if(item[0]<=size&&item[0]<=pricestock[1][0]){
														amount[j][0]+=item[0];pricestock[1][0]-=item[0];
														size-=item[0];check=t;
													}else if(item[0]>pricestock[1][0]){
														System.out.println("fail :"+flower[0]+" not enough in stock <"+pricestock[1][0]+">");
													}else{
														size=-1;
													}
												}else if(color.equals("2")){
													System.out.print("amount : ");lek=sc.nextLine();q="amount : ";
													item[1]=op.stringtoint(lek,q);
													if(item[1]<=size&&item[1]<=pricestock[1][1]){
														amount[j][1]+=item[1];pricestock[1][1]-=item[1];
														size-=item[1];check=t;
													}else if(item[1]>pricestock[1][1]){
														System.out.println("fail :"+flower[1]+" not enough in stock <"+pricestock[1][1]+">");
													}else{
														size=-1;
													}
												}else if(color.equals("3")){
													System.out.print("amount : ");lek=sc.nextLine();q="amount : ";
													item[2]=op.stringtoint(lek,q);
													if(item[2]<=size&&item[2]<=pricestock[1][2]){
														amount[j][2]+=item[2];pricestock[1][2]-=item[2];
														size-=item[2];check=t;
													}else if(item[2]>pricestock[1][2]){
														System.out.println("fail :"+flower[2]+" not enough in stock <"+pricestock[1][2]+">");
													}else{
														size=-1;
													}
												}	
											}else if(type.equals("l")){
												while(!color.equals("1")&&!color.equals("2")&&!color.equals("3")&&!color.equals("0")){
													System.out.print("<Lily>\nOrange(1)cost 25 THB   Red(2)cost 35 THB   White(3)cost 30 THB  ");
													System.out.print("<Back(0)>\nColor :");color=sc.nextLine();
													if(!color.equals("1")&&!color.equals("2")&&!color.equals("3")&&!color.equals("0"))
														System.out.println("fail :wrong color");
												}
												if(!color.equals("0"))
													System.out.println("You have to input amount <"+size+">");
												if(color.equals("1")){
													System.out.print("amount : ");lek=sc.nextLine();q="amount : ";
													item[3]=op.stringtoint(lek,q);
													if(item[3]<=size&&item[3]<=pricestock[1][3]){
														amount[j][3]+=item[3];pricestock[1][3]-=item[3];
														size-=item[3];check=t;
													}else if(item[3]>pricestock[1][3]){
														System.out.println("fail :"+flower[3]+" not enough in stock <"+pricestock[1][3]+">");
													}else{
														size=-1;
													}
												}else if(color.equals("2")){
													System.out.print("amount : ");lek=sc.nextLine();q="amount : ";
													item[4]=op.stringtoint(lek,q);
													if(item[4]<=size&&item[4]<=pricestock[1][4]){
														amount[j][4]+=item[4];pricestock[1][4]-=item[4];
														size-=item[4];check=t;
													}else if(item[4]>pricestock[1][4]){
														System.out.println("fail :"+flower[4]+" not enough in stock <"+pricestock[1][4]+">");
													}else{
														size=-1;
													}
												}else if(color.equals("3")){
													System.out.print("amount : ");lek=sc.nextLine();q="amount : ";
													item[5]=op.stringtoint(lek,q);
													if(item[5]<=size&&item[5]<=pricestock[1][5]){
														amount[j][5]+=item[5];pricestock[1][5]-=item[5];
														size-=item[5];check=t;
													}else if(item[5]>pricestock[1][5]){
														System.out.println("fail :"+flower[5]+" not enough in stock <"+pricestock[1][5]+">");
													}else{
														size=-1;
													}
												}
											}else if(type.equals("t")){
												while(!color.equals("1")&&!color.equals("2")&&!color.equals("3")&&!color.equals("0")){
													System.out.print("<Tulip>\nYellow(1)cost 25 THB   Red(2)cost 30 THB   Orange(3)cost 30 THB  ");
													System.out.print("<Back(0)>\nColor :");
													color=sc.nextLine();
													if(!color.equals("1")&&!color.equals("2")&&!color.equals("3")&&!color.equals("0"))
														System.out.println("fail :wrong color");
												}
												if(!color.equals("0"))
													System.out.println("You have to input amount <"+size+">");
												if(color.equals("1")){
													System.out.print("amount : ");lek=sc.nextLine();q="amount : ";
													item[6]=op.stringtoint(lek,q);
													if(item[6]<=size&&item[6]<=pricestock[1][6]){
														amount[j][6]+=item[6];pricestock[1][6]-=item[6];
														size-=item[6];check=t;
													}else if(item[6]>pricestock[1][6]){
														System.out.println("fail :"+flower[6]+" not enough in stock <"+pricestock[1][6]+">");
													}else{
														size=-1;
													}
												}else if(color.equals("2")){
													System.out.print("amount : ");lek=sc.nextLine();q="amount : ";
													item[7]=op.stringtoint(lek,q);
													if(item[7]<=size&&item[7]<=pricestock[1][7]){
														amount[j][7]+=item[7];pricestock[1][7]-=item[7];
														size-=item[7];check=t;
													}else if(item[7]>pricestock[1][7]){
														System.out.println("fail :"+flower[7]+" not enough in stock <"+pricestock[1][7]+">");
													}else{
														size=-1;
													}
												}else if(color.equals("3")){
													System.out.print("amount : ");lek=sc.nextLine();q="amount : ";
													item[8]=op.stringtoint(lek,q);
													if(item[8]<=size&&item[8]<=pricestock[1][8]){
														amount[j][8]+=item[8];pricestock[1][8]-=item[8];
														size-=item[8];check=t;
													}else if(item[8]>pricestock[1][8]){
														System.out.println("fail :"+flower[8]+" not enough in stock <"+pricestock[1][8]+">");
													}else{
														size=-1;
													}
												}
											}
										}if(size==0){
											int more=0;
												do{
													System.out.print("How many bundle?: ");lek=sc.nextLine();q="How many bundle?: ";
													more=op.stringtoint(lek,q);
													check=t;
													if(more>1){
														for(int i2=0;i2<flower.length;i2++){
															if(amount[j][i2]*(more-1)>pricestock[1][i2])
																check=f;
														}
														if(check.equals(f)){
															System.out.println("fail :flowers not enough");
														}
														else if(check.equals(t)){
															for(int ct=0;ct<flower.length;ct++){
															pricestock[1][ct]-=amount[j][ct]*(more-1);
															}
															c[counting]+=(more-1);
															j++;counting++;
															System.out.println("--------------------------------------------------------------------");
															System.out.println("                        Next order bundle");
														}
													}else if(more==1){
														c[counting]=1;j++;counting++;
													}else 
														check=f;
												}while(check.equals(f));
										}else if(size<0){
											System.out.println("fail :bundle fail please input size again");
											for(int renew=0;renew<9;renew++){
												pricestock[1][renew]+=amount[j][renew];
												amount[j][renew]=0;check=f;
											}

										}
									}
								}while(check.equals(f));
							}
							check=f;
							input="none";
							System.out.println("--------------------------------------------------------------------");
							while(!input.equals("a")&&!input.equals("b")&&!input.equals("endorder")){
								System.out.print("set by us(a) or custom(b) or check stock(c) : ");input=sc.nextLine();input.toLowerCase();
								if(input.equals("endorder"))
									System.out.printf("________________________End Order Tee(%d)________________________\n",ordertee);
								else if(input.equals("c"))
									checkstock2();
								else if(!input.equals("a")&&!input.equals("b")&&!input.equals("c"))
									System.out.println("fail :wrong choice");
							}
						}while(!input.equals("endorder"));
						ordertee++;
						if(input.equals("endorder")){
							int sum=0;
							for(int bundle=0;bundle<j;bundle++){
								int total=0;
								System.out.println("Bundle "+(bundle+1)+" x"+c[bundle]);
								for(int inbun=0;inbun<flower.length;inbun++){
									if(amount[bundle][inbun]>0){
										System.out.println("\t"+flower[inbun]+" amount : "+amount[bundle][inbun]+" price "+amount[bundle][inbun]*pricestock[0][inbun]);
										total+=amount[bundle][inbun]*pricestock[0][inbun];
									}	
								}
								System.out.println("\tbundle "+(bundle+1)+" cost : "+total+" x "+c[bundle]+" = "+(total*c[bundle]));
								total*=c[bundle];
								sum+=total;
							}System.out.println("Total "+sum+" Bath.\n");
						}
						
					}else if(input.equals("c")){
						checkstock2();
					}else if(input.equals("logout")){
						System.out.println("---------Logout---------");check=f;
					}
					else 
						System.out.println("Wrong input please type again");
				
				}while(!input.equals("logout"));
			}
			else if(check.equals("close")){
				checkstock2();
			}
		}while(!check.equals("close"));
	}
}