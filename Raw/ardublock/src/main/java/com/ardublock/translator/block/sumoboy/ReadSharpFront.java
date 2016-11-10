package com.ardublock.translator.block.sumoboy;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.NumberBlock;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class ReadSharpFront extends TranslatorBlock
{
    
    public ReadSharpFront(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		translator.addHeaderFile("SumoBoy.h");
                translator.addDefinitionCommand("SumoBoy sumoboy;");
		translator.addSetupCommand("sumoboy.init();");

		String ret ="sumoboy.sharp.readFrontVal()";
		return codePrefix + ret + codeSuffix;
	}
}
