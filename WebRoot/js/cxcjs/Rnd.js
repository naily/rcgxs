// JavaScript Document
/**随机数公共类
*/


var Rnd = {
	/**
	 * 获取随机整数,范围是 start <= 返回值 < end
	 * 
	 * @param start, Number: 返回值大于等于start
	 * @param end, Number: 返回值小于end
	 */
	getNumber : function(start, end) {
		start = start || 0, end = end || 10;
		return Math.floor(start + (end - start) * Math.random());
	},

	/** Hex字符集合 0123456789ABCDEF */
	charHex : "0123456789ABCDEF",
	/** 大写字母集合 */
	charUpper : "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
	/** 大写字母和数字集合 */
	charUpperAndNumber : "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ",
	/** 小写字母集合 */
	charLower : "abcdefghijklmnopqrstuvwxyz",
	/** 数字集合 */
	charNumber : "0123456789",
	/** 大小写字母和数字集合 */
	charAll : "01234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ",

	/**
	 * 获取随机字符串 
	 * 
	 * @param size, Int: 字符串长度,默认为16
	 * @param seeds, String: 产生随机字母的来源字符串,默认为charAll
	 * @see Rnd.charAll
	 */
	getString : function(size, seeds) {
		seeds = seeds || this.charAll;
		size = size || 16;
		var len = seeds.length;
		var arr = new Array(size);
		for (var i = 0; i < size; i++)
			arr[i] = seeds.charAt(this.getNumber(0, len));

		return arr.join("");
	}
	
}