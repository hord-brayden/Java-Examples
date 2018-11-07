package byui.cit260.afghan_trail.controller;

import afghan_trail.Afghan_Trail;

public class Map {
	
	public static String displayMap (int progress) {
		//Afghan_Trail.getOutFile().print("Progress: " + progress + "\n");
		char[] p = new char[]{
			'o','/','/','_','_',
			'o','|','|','\\','\\',
			'o','\\','_','_','_',
			'o','/','_','_','_',
			'o','\\','\\','\\','_'};
		
		//used to set and reset color
		//public static final String ANSI_RED = "\u001B[31m";
		//public static final String ANSI_RESET = "\u001B[0m";
		
                for (int i = 0; i <= progress; i ++){
                    p[i] = 'X';
                }
		
	    String mapString = "\n"  +
		"\n"  +
		"                        ,-.^._                 _\n"  +
		"               "+p[24]+"     Maymana      `-.            ,' ;\n"  +
		"               /"+p[23]+"-.  ,----' "+p[15]+"__"+p[14]+"_"+p[13]+"_"+p[12]+" `-.   _  ,-.,'  `\n"  +
		"            _.'  "+p[22]+"`--'     /   ^^  \\"+p[11]+"  `-' '-'      ;\n"  +
		"           :      "+p[21]+"  "+p[19]+"_"+p[18]+"_"+p[17]+"_"+p[16]+" ^ ^^^^    "+p[10]+"             ;    __,-.\n"  +
		"           ,'      "+p[20]+"/       ^   Mazar-i-Sharif       ;_,-',.__'--.\n"  +
		"          :      Herat     ^^         \\"+p[9]+"            ,--```    `--'\n"  +
		"          :                ^^          \\"+p[8]+"         ;\n"  +
		"          :             ^^^^^       ^^   "+p[7]+"        :\n"  +
		"          ;         ^  ^ ^ ^        ^^^  "+p[6]+"       :\n"  +
		"         (       ^ ^ ^ ^             "+p[4]+"_  |       ;\n"  +
		"          `-.    ^ ^ ^ ^       __"+p[3]+"__/   "+p[5]+"      ,'\n"  +
		"            ;    ^ ^ ^        "+p[2]+"       Kabul   :\n"  +
		"          .'    ^  ^         /  ^^^      .-._,' \n"  +
		"        .'                  "+p[1]+"    ^       `.               \n"  +
		"     _.'                   /            .__;  \n"  +
		"     `._                  "+p[0]+"           ;                       \n"  +
		"        `.             Kandahar       :    \n"  +
		"          `.               ,..__,---._;     \n"  +
		"            `-.__         :                                          \n"  +
		"                 `.--.____;                                          \n";
		
            return mapString;		
	}
}