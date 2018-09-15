package rd.f.tools;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.List;

public class MathTool {

	/**
	 * 对字符串进行MD5加密
	 * 
	 * @param str 要加密的字符串
	 * @return 加密后的MD5字符串
	 */
	public final String MD5(String str) {
		char hexDigits[] = { // 用来将字节转换成 16 进制表示的字符
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = str.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte tmp[] = mdTemp.digest(); // MD5 的计算结果是一个 128 位的长整数，
			// 用字节表示就是 16 个字节
			char strs[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
			// 所以表示成 16 进制需要 32 个字符
			int k = 0; // 表示转换结果中对应的字符位置
			for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节
				// 转换成 16 进制字符的转换
				byte byte0 = tmp[i]; // 取第 i 个字节
				strs[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
				// >>> 为逻辑右移，将符号位一起右移
				strs[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
			}
			return new String(strs); // 换后的结果转换为字符串
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 把 Double数 转成 指定精度的 字符串格式(用于显示)	被convertNumberToSpecifiedFormat(Object numberObject, String convertedFormat)-替代
	 * @param floatNumber	Double数
	 * @param newScale	小数点后的精度
	 * 如:	convertFloatNumberToSpecifiedPrecision(1.7976931348623157E308,2); --> 3.14d
	 * 		convertFloatNumberToSpecifiedPrecision(1.7976931348623157E308,3); --> 3.142d
	 */
	@Deprecated
	public String convertDoubleNumberToSpecifiedPrecision(Double doubleNumber , int newScale){
		BigDecimal setScale = new BigDecimal(doubleNumber).setScale(newScale, RoundingMode.HALF_EVEN);
		return setScale.toString();
	}
	
    /**
     * 获取可变参数(double) 中最大的一个	被getMaxOrMinNumber替代
     * @param params    
     * @return
     */
	@Deprecated
    public double maxOfAllMathNumber(double ...params) {
        double hypotheticalMaxNumber = params[0];        //假设的最大数
        
        for(int i = 0; i <= params.length - 1; i++){
            if(hypotheticalMaxNumber < params[i]){
                hypotheticalMaxNumber = params[i];
            }
        }
        
        return hypotheticalMaxNumber;
    }
    
    /**
     * 获取可变参数(double) 中绝对值最大的一个
     * @param params    
     * @return
     */
	public float maxAbsOfAllMathNumber(float[]... parameters){
		float max = Math.abs((parameters[0])[0]);        //假设的最大数
		for(int w = 0  ; w<=parameters.length-1 ; w++){
			for(int n = 0 ; n<=(parameters[w]).length-1 ; n++){
				if(max < Math.abs((parameters[w])[n])){
					max = Math.abs((parameters[w])[n]);
				}
			}
		}
		return max;
	}
    
    /**
     * 获取可变参数(double) 中最小的一个	被getMaxOrMinNumber替代
     * @param params    
     * @return
     */
	@Deprecated
    public double minOfAllMathNumber(double ...params) {
        double hypotheticalMinNumber = params[0];        //假设的最大数
        
        for(int i = 0; i <= params.length - 1; i++){
            if(hypotheticalMinNumber > params[i]){
                hypotheticalMinNumber = params[i];
            }
        }
        
        return hypotheticalMinNumber;
    }
    
    /**
     * 获取可变参数(float) 中最大的一个
     * @param params    
     * @return
     */
    @Deprecated
    public float maxOfAllMathNumber(float ...params) {
    	float hypotheticalMaxNumber = params[0];        //假设的最大数
    	
    	for(int i = 0; i <= params.length - 1; i++){
    		if(hypotheticalMaxNumber < params[i]){
    			hypotheticalMaxNumber = params[i];
    		}
    	}
    	
    	return hypotheticalMaxNumber;
    }
    
    /**
     * 获取可变参数(float[]) 中最大的一个
     * @param params    
     * @return
     */
	public float maxOfAllMathNumber(float[]... parameters){
		float max = (parameters[0])[0];        //假设的最大数
		for(int w = 0  ; w<=parameters.length-1 ; w++){
			for(int n = 0 ; n<=(parameters[w]).length-1 ; n++){
				if(max < (parameters[w])[n]){
					max = (parameters[w])[n];
				}
			}
		}
		return max;
	}
    
    /**
     * 获取可变参数(float) 中最小的一个	被getMaxOrMinNumber替代
     * @param params    
     * @return
     */
	@Deprecated
    public float minOfAllMathNumber(float ...params) {
    	float hypotheticalMinNumber = params[0];        //假设的最大数
    	
    	for(int i = 0; i <= params.length - 1; i++){
    		if(hypotheticalMinNumber > params[i]){
    			hypotheticalMinNumber = params[i];
    		}
    	}
    	
    	return hypotheticalMinNumber;
    }
    
    /**
     * 获取可变参数(float[]) 中最小的一个
     * @param params    
     * @return
     */
	public float minOfAllMathNumber(float[]... parameters){
		float min = (parameters[0])[0];        //假设的最小数
		for(int w = 0  ; w<=parameters.length-1 ; w++){
			for(int n = 0 ; n<=(parameters[w]).length-1 ; n++){
				if(min > (parameters[w])[n]){
					min = (parameters[w])[n];
				}
			}
		}
		return min;
	}
    
    /**
     * 将Double型数字 转换成带 千分位格式-->过时，被 convertNumberToSpecifiedFormat(Object numberObject, String convertedFormat)替代
     * 4372744.62    ->  4,372,744.62
     * -305917.64   ->  -305,917.64
     * thousandsSymbol
     * @param str
     * @return
     */
	@Deprecated
    public String convertNumberStrToThousndsSymbol(Double doubleNum) {
        return DecimalFormat.getNumberInstance().format(doubleNum);
    }
    
    /**
     * 前面以0补齐方式，构造指定长度的字串	被getMaxOrMinNumber替代
     * 	如：removeForwardZero("00001102")
     * 返回： 1102
     * @param str 需要操作的字符串
     * @param requeredLength
     * @return
     */
	@Deprecated
    public String constructSpecifiedLengthString(String str , int requeredLength){
        
        if(str.length() < requeredLength){  //数字串的长度 小于 指定的长度
            StringBuilder sb = new StringBuilder();
            int a = requeredLength - str.length();
            for(int i=1;i<=a;i++){
                sb.append("0");
            }
            sb.append(str);
            return sb.toString();
        }else if(str.length() == requeredLength){   //数字串的长度 等于 指定的长度
            return str;
        }else{  //数字串的长度 大于 指定的长度
            return str.substring((str.length()-requeredLength) , str.length());
        }
    }
    
    /**
     * 去掉 字符串 前面的 0
     * @param str
     * @return
     */
	public String removeForwardZero(String str) {
		int len = str.length();// 取得字符串的长度
		int index = 0;// 预定义第一个非零字符串的位置

		char strs[] = str.toCharArray();// 将字符串转化成字符数组
		for (int i = 0; i < len; i++) {
			if ('0' != strs[i]) {
				index = i;// 找到非零字符串并跳出
				break;
			}
		}
		String strLast = str.substring(index, len);// 截取字符串
		return strLast;
	}
    
    /**
     * 找到字符串中第几[0,1,2...)个指定的字符所在的index
     * @param originalStr
     * 如：".com.hezhi.yundaizhang.d_fundation.http.DenglumokuaiHttp.denglu(DenglumokuaiHttp.java:19)"
     * findTheIndexOfSeveralthChar(path, '.', 0);
     * @param specifiedChar
     * @param severalth
     * @return [0,1,2,3...)  指定条件下的目标 ，         -1 指定条件下不存在目标
     */
    public int findTheIndexOfSeveralthChar(String originalStr , char specifiedChar , int severalth){
        byte[] originalbytes = originalStr.getBytes();
        int specifiedCharsCounts = 0;
        
        //拿到此字符的总个数,便于开辟specifiedCharsIndex空间
        for(int a = 0;a<=originalStr.length()-1;a++){
            if((originalbytes[a] - specifiedChar) == 0){
                specifiedCharsCounts ++;
            }
        }
        
        if(specifiedCharsCounts > severalth){   //在可查找的范围内
            int[] specifiedCharsIndex = new int[specifiedCharsCounts];
            specifiedCharsCounts = 0;   //重置 计数
            for(int i=0 ; i<=originalStr.length()-1 ; i++){
                if((originalbytes[i] - specifiedChar) == 0){
                    specifiedCharsIndex[specifiedCharsCounts] = i;
                    specifiedCharsCounts++;
                }
            }
            return specifiedCharsIndex[severalth];
        }else{  //指定条件下不存在目标
            return -1;
        }
    }
    
	/**
	 * 角度转弧度
	 * @param jiaoduValue	将要转换的角度
	 * @return
	 */
	public Float jiaoduConvertHudu(Float jiaoduValue) {
		return (float) (Math.PI / 180 * jiaoduValue);
	}
	
	/**
	 * 弧度转角度
	 * @param jiaoduValue	将要转换的弧度
	 * @return
	 */
	public Float huduConvertJiaodu(Float huduValue){
		return (float) (180*Math.PI * huduValue);
	}
	
    /**
     * 判断手机号码是否合法
     * @param mobiles
     * @return
     */
    public boolean judgeTheMobilePhoneNumberIsLeagle(String mobileStr) {
        String telRegular = "^1[3|4|5|7|8][0-9]\\d{8}$";
        return mobileStr.matches(telRegular) ;
    }
    
    /**
     * 判断邮箱是否合法
     * @param mobiles
     * @return
     */
    public boolean judgeTheEmailIsLeagle(String emailStr) {
    	String emailRegular = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    	return emailStr.matches(emailRegular) ;
    }
    
	/**
	 * 把数字转换成指定的格式(包括小数点，17位之后必然发生精度损失)
	 * 0和#都是占位符,
	 * 	0比实际数字的位数多，不足的地方用0补上。
	 * 	#比实际数字的位数多，不变,或者(#比实际数字的位数少：整数部分不改动，小数部分，四舍五入)
	 * like:	等于"0000.0000"	convertNumberToSpecifiedFormat(0.00f, "0000.0000")-->0000.0000
	 * like:	千分号	convertNumberFormat(23424348754238.34, "###,##0.00")-->23,424,348,754,238.34
	 * like:	千分号	convertNumberFormat(0, "###,##0.00")-->0.00 
	 * like:	千分号	convertNumberFormat(-8800, "###,###.00")-->-8,800.00
	 * like:	万分号	convertNumberFormat(23424348754238.34, "####,####.000")-->23,4243,4875,4238.340
	 * like:	万分号	convertNumberFormat(23424348754238.34, "##,##.00")-->23,42,43,48,75,42,38.34
	 * like:	固定位数，前面补0	convertNumberFormat(88, "0000")-->0088-->0088.00
	 * like:	固定位数，前面、小数点后面补0	convertNumberFormat(88, "0000.00")
	 * like:	转成科学计数	convertNumberFormat(23424348754238.34, "0.000E000")-->2.342E013
	 * like:	科学计数转指定格式	convertNumberFormat(31415.926E002, "###,###.000")-->3,141,592.600
	 * like:	高精度转换(也就17位)	convertNumberToSpecifiedFormat(3.1415926535897956789E18, "#.####################")-->3141592653589795800
	 * @param numberObject
	 * @param convertedFormat
	 * @return
	 */
	public <N> String convertNumberToSpecifiedFormat(N numberObject, String convertedFormat){
		DecimalFormat decimalFormat = new DecimalFormat(convertedFormat);
		String formatedNumber = decimalFormat.format(numberObject);
		return formatedNumber;
	}
	
	/**
	 * 在数字数组中得到最大、最小、绝对值最大、绝对值最小的数字(重载)
	 * 2017-07-22
	 * like:
		Double[] numbers = new Double[3];
		numbers[0] = 88.987654321d;
		numbers[1] = -99d;
		numbers[2] = 14d;
		Double MaxOrMinNumberU = getMaxOrMinNumber(numbers, "max");

		List<Double> numberList = new ArrayList<Double>();
		numberList.add(88.987654321d);
		numberList.add(-99d);
		numberList.add(14d);
		Double MaxOrMinNumberD = getMaxOrMinNumber(numberList, "max");
	 * @param numbers 数字的列表
	 * @param maxOrMinTag	
	 * 		"max"--找最大数，
	 * 		"min"--找最小数，
	 * 		"absMax"--绝对值最大，
	 * 		"absMin"--绝对值最小
	 * @return
	 */
	public <N> N getMaxOrMinNumber(N[] numbers, String maxOrMinTag){
		int assumedAimPosition = 0;
		Double assumedAimNumber = Double.valueOf(convertNumberToSpecifiedFormat(numbers[0], "#.####################"));	//最高精度也就到17位
		for(int i=0;i<=numbers.length-1;i++){
			Double currentPositionNumber = Double.valueOf(convertNumberToSpecifiedFormat(numbers[i], "#.####################"));	//最高精度也就到17位
			if("max".equals(maxOrMinTag)){	//找最大的数字
				if(assumedAimNumber<currentPositionNumber){
					assumedAimPosition = i;
					assumedAimNumber = currentPositionNumber;
				}
			}else if("min".equals(maxOrMinTag)){	//找最小的数字
				if(assumedAimNumber>currentPositionNumber){
					assumedAimPosition = i;
					assumedAimNumber = currentPositionNumber;
				}
			}else if("absMax".equals(maxOrMinTag)){	//找绝对值最大的数字
				if(Math.abs(assumedAimNumber)<Math.abs(currentPositionNumber)){
					assumedAimPosition = i;
					assumedAimNumber = currentPositionNumber;
				}
			}else if("absMin".equals(maxOrMinTag)){	//找绝对值最大的数字
				if(Math.abs(assumedAimNumber)>Math.abs(currentPositionNumber)){
					assumedAimPosition = i;
					assumedAimNumber = currentPositionNumber;
				}
			}
		}
		return numbers[assumedAimPosition];
	}
	
	/**
	 * 在数字列表中得到最大、最小、绝对值最大、绝对值最小的数字(重载)
	 * 2017-07-22
	 * like:
			Double[] numbers = new Double[3];
			numbers[0] = 88.987654321d;
			numbers[1] = -99d;
			numbers[2] = 14d;
			Double MaxOrMinNumberU = getMaxOrMinNumber(numbers, "max");
	
			List<Double> numberList = new ArrayList<Double>();
			numberList.add(88.987654321d);
			numberList.add(-99d);
			numberList.add(14d);
			Double MaxOrMinNumberD = getMaxOrMinNumber(numberList, "max");
	 * @param numbers 数字的列表
	 * @param maxOrMinTag	
	 * 		"max"--找最大数，
	 * 		"min"--找最小数，
	 * 		"absMax"--绝对值最大，
	 * 		"absMin"--绝对值最小
	 * @return
	 */
	public <N> N getMaxOrMinNumber(List<N> numbers, String maxOrMinTag){
		int assumedAimPosition = 0;
		Double assumedAimNumber = Double.valueOf(convertNumberToSpecifiedFormat(numbers.get(0), "#.####################"));	//最高精度也就到17位
		for(int i=0;i<=numbers.size()-1;i++){
			Double currentPositionNumber = Double.valueOf(convertNumberToSpecifiedFormat(numbers.get(i), "#.####################"));	//最高精度也就到17位
			if("max".equals(maxOrMinTag)){	//找最大的数字
				if(assumedAimNumber<currentPositionNumber){
					assumedAimPosition = i;
					assumedAimNumber = currentPositionNumber;
				}
			}else if("min".equals(maxOrMinTag)){	//找最小的数字
				if(assumedAimNumber>currentPositionNumber){
					assumedAimPosition = i;
					assumedAimNumber = currentPositionNumber;
				}
			}else if("absMax".equals(maxOrMinTag)){	//找绝对值最大的数字
				if(Math.abs(assumedAimNumber)<Math.abs(currentPositionNumber)){
					assumedAimPosition = i;
					assumedAimNumber = currentPositionNumber;
				}
			}else if("absMin".equals(maxOrMinTag)){	//找绝对值最大的数字
				if(Math.abs(assumedAimNumber)>Math.abs(currentPositionNumber)){
					assumedAimPosition = i;
					assumedAimNumber = currentPositionNumber;
				}
			}
		}
		return numbers.get(assumedAimPosition);
	}
	
	/**
	 * 在数字数组中得到 对原始数据累加求和、对原始数据绝对值处理后累加求和、对原始数据求平均值、对原始数据绝对值处理后求平均值(重载)
	 * 2017-07-22
	 * like:
		Float[] numbers = new Float[3];
		numbers[0] = 11.11f;
		numbers[1] = -22.22f;
		numbers[2] = 55.55f;
		Float wantedValueInNumberU = (float) (getWantedValueInNumbers(numbers, "sumOfOriginalNumber") + 0.00f);
		System.out.println(wantedValueInNumberU);
		
		List<Double> numberList = new ArrayList<Double>();
		numberList.add(11.11d);
		numberList.add(-22.22d);
		numberList.add(55.55d);
		Double wantedValueInNumberD = getWantedValueInNumbers(numberList, "sumOfOriginalNumber");
		System.out.println(wantedValueInNumberD);
	 * @param numbers 数字的列表
	 * @param wantedTag		"sumOfOriginalNumber"--对原始数据累加求和，
	 * 						"sumOfAbsNumber"--对原始数据绝对值处理后累加求和
	 * 						"averageOfOriginalNumber"--对原始数据求平均值
	 * 						"averageOfAbsNumber"--对原始数据绝对值处理后求平均值
	 * @return
	 */
	public <N> Double getWantedValueInNumbers(N[] numbers, String wantedTag){
		Double assumedAimNumber = 0.00d;
		for(int i=0;i<=numbers.length-1;i++){
			Double currentPositionNumber = Double.valueOf(convertNumberToSpecifiedFormat(numbers[i], "#.####################"));	//最高精度也就到17位
			if("sumOfOriginalNumber".equals(wantedTag)){	//对原始数据累加求和
				assumedAimNumber = assumedAimNumber + currentPositionNumber;
			}else if("sumOfAbsNumber".equals(wantedTag)){	//对原始数据绝对值处理后累加求和
				assumedAimNumber = assumedAimNumber + Math.abs(currentPositionNumber);
			}else if("averageOfOriginalNumber".equals(wantedTag)){	//对原始数据求平均值
				assumedAimNumber = assumedAimNumber + currentPositionNumber;
			}else if("averageOfAbsNumber".equals(wantedTag)){	//对原始数据绝对值处理后求平均值
				assumedAimNumber = assumedAimNumber + Math.abs(currentPositionNumber);
			}
		}
		
		if("averageOfOriginalNumber".equals(wantedTag)){	//对原始数据求平均值
			assumedAimNumber = assumedAimNumber/numbers.length;
		}else if("averageOfAbsNumber".equals(wantedTag)){	//对原始数据绝对值处理后求平均值
			assumedAimNumber = assumedAimNumber/numbers.length;
		}
		return assumedAimNumber;
	}
	
	/**
	 * 在数字数组中得到 对原始数据累加求和、对原始数据绝对值处理后累加求和、对原始数据求平均值、对原始数据绝对值处理后求平均值(重载)
	 * 2017-07-22
	 * like:
		Float[] numbers = new Float[3];
		numbers[0] = 11.11f;
		numbers[1] = -22.22f;
		numbers[2] = 55.55f;
		Float wantedValueInNumberU = (float) (getWantedValueInNumbers(numbers, "sumOfOriginalNumber") + 0.00f);
		System.out.println(wantedValueInNumberU);
		
		List<Double> numberList = new ArrayList<Double>();
		numberList.add(11.11d);
		numberList.add(-22.22d);
		numberList.add(55.55d);
		Double wantedValueInNumberD = getWantedValueInNumbers(numberList, "sumOfOriginalNumber");
		System.out.println(wantedValueInNumberD);
	 * @param numbers 数字的列表
	 * @param wantedTag		"sumOfOriginalNumber"--对原始数据累加求和，
	 * 						"sumOfAbsNumber"--对原始数据绝对值处理后累加求和
	 * 						"averageOfOriginalNumber"--对原始数据求平均值
	 * 						"averageOfAbsNumber"--对原始数据绝对值处理后求平均值
	 * @return
	 */
	public <N> Double getWantedValueInNumbers(List<N> numbers, String wantedTag){
		Double assumedAimNumber = 0.00d;
		for(int i=0;i<=numbers.size()-1;i++){
			Double currentPositionNumber = Double.valueOf(convertNumberToSpecifiedFormat(numbers.get(i), "#.####################"));	//最高精度也就到17位
			if("sumOfOriginalNumber".equals(wantedTag)){	//对原始数据累加求和
				assumedAimNumber = assumedAimNumber + currentPositionNumber;
			}else if("sumOfAbsNumber".equals(wantedTag)){	//对原始数据绝对值处理后累加求和
				assumedAimNumber = assumedAimNumber + Math.abs(currentPositionNumber);
			}else if("averageOfOriginalNumber".equals(wantedTag)){	//对原始数据求平均值
				assumedAimNumber = assumedAimNumber + currentPositionNumber;
			}else if("averageOfAbsNumber".equals(wantedTag)){	//对原始数据绝对值处理后求平均值
				assumedAimNumber = assumedAimNumber + Math.abs(currentPositionNumber);
			}
		}
		
		if("averageOfOriginalNumber".equals(wantedTag)){	//对原始数据求平均值
			assumedAimNumber = assumedAimNumber/numbers.size();
		}else if("averageOfAbsNumber".equals(wantedTag)){	//对原始数据绝对值处理后求平均值
			assumedAimNumber = assumedAimNumber/numbers.size();
		}
		return assumedAimNumber;
	}
	
}
