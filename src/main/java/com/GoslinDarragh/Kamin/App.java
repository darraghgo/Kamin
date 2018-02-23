 package com.GoslinDarragh.Kamin;
 
import	java.io.File;
import	java.io.IOException;
import	java.util.Arrays;
import	java.util.Date;
import	java.util.Scanner;
import	org.apache.logging.log4j.Level;
import	org.apache.logging.log4j.LogManager;
import	org.apache.logging.log4j.Logger;
import	org.apache.logging.log4j.core.config.Configurator;
import	joptsimple.OptionException;
import	joptsimple.OptionParser;
import	joptsimple.OptionSet;
/*****************************************************************
	*
	*	 Date:	2017
	*	 @author	COR
	*
	*	
	*	The	purpose	of	this	application	is	to	provide	an	example	for	the	following:
	*	
	*	-	Demonstrates	the	use	of	development	tools	:	GIT,	MAVEN,	Eclipse
	*	-	Demonstrates	how	to	use	Eclipse
	*	-	Provides	a	refresher	of	OOP	in	Java
	*	-	Provide	an	introduction	to	project	file	structure	layout	-	MAVEN	Archetype
	*	-	Show	how	to	setup	Log4j2
	*	
	*****************************************************************/
public	class	App	
{
				public	static	void	main(	String[]	args	)
				{
	 	 //	To	view	the	arguments	being	entered
	 	 seeCommandlineInput(args);
			
	 	 //	To	instantiate	App	class	based	in	the	parameters	entered	at	the	commandline
	 	 actionCommandlineInput(args);
				}
				
	 //	DATA
	 //............................................................
	 //define	attributes
	 private	Scanner	someInput;
	 private	Date	today;
	 //	This	is	added	to	every	class	that	needs	to	log	with	one	change
	 //	The	getLogger(	)	part	should	contain	the	name	of	the	class	its	in
	 private	static	Logger	LOG;
	 //	CONSTRUCTORS
	 //............................................................
	 public	App(	Level	logLevel	)
	 {	 	
	 	 //associate	logging	with	this	class	so	know	the	messages	that	came	from	objects	of	this	class
	 	 LOG	=	LogManager.getLogger(App.class);
	 	 Configurator.setLevel(LOG.getName(),	logLevel);
	 	
	 	 //	Check	the	log	level	requested
	 	 LOG.info("Commandline	requested	log	level:"	+	logLevel	);	 	
	 	 LOG.info("Application	started	with	log	level	debug:"	+	LOG.isDebugEnabled());
	 	
	 	 //test	the	logging
	 	 testLogOutput();
	 	
	 	 this.someInput	=	new	Scanner(System.in);
	 	
	 	 //do	something	here
	 	 System.out.println("	\n	Soon	...	stuff	will	happen	here");	 	
	 	
	 	 //pause	before	exit	(this	is	only	useful	if	an	error	occurs)
								System.out.println("	\n	Press	enter	to	exit	the	program");
	 	 this.someInput.nextLine();
	 	 //close	the	program	without	error
	 	 System.exit(0);
	 }
	 public	App()
	 {
	 	 this(	Level.INFO	);
	 }
				
				
	 //	METHODS	used	by	main()	or	debug	methods	-	note	they	are	static	methods
	 //............................................................
	 /**
	 	*	action	the	arguments	presented	at	the	command	line
	 	*	instantiate	the	App	class	based	on	the	arguments	passed
	 	*/
	 	private	static	void	actionCommandlineInput(	String	args[]	)
	 	{
	 	 	try
	 	 	 {	
	 	 	 	 final	OptionParser	optionParser	=	new	OptionParser();
				
	 	 	 	 //define	the	allowed	arguments
	 	 	 	 optionParser.acceptsAll(Arrays.asList("v",	"verbose"),	"Set	logging	level	to	DEBUG	to	see	all	levels	of	log	messages").forHelp();	 	 	
	 	 	 	 optionParser.acceptsAll(Arrays.asList("h",	"help"),	"Display	help/usage	information").forHelp();
	 	 	 	 optionParser.acceptsAll(Arrays.asList("r",	"version"),	"Display	program	version	information").forHelp();
				
	 	 	 	 final	OptionSet	options	=	optionParser.parse(args);
				
	 	 	 	 if	(options.has("help"))
				{
	 	 	 	 	 System.out.println("This	program	takes	an	SQL	database	with	a	User table	as	displays	the	users.");
	 	 	 	 	 System.out.println("It	is	provided	as	an	example	for	teaching	Java programming.");
	 	 	 	 	 printUsage(optionParser);
	 	 	 	 	 System.exit(0);
				}
				
	 	 	 	 if	(options.has("version"))
				{
	 	 	 	 	 System.out.println("Pythia	version	0.3");
	 	 	 	 	 System.exit(0);
				}
				
	 	 	 			//	valid	input	so	start	the	program	with	the	name	of	the	database	file	to	use
	 	 	 			if	(options.has("verbose")	)
	 	 	 			{
	 	 	 	 			Level	logLevel	=	Level.DEBUG;
	 	 	 	 			System.out.println("RUN	WITH:	logging	level	requested:	"	+	logLevel);
	 	 	 	 			App	anApp	=	new	App(logLevel);
	 	 	 			}
	 	 	 			else
	 	 	 			{
	 	 	 	 			System.out.println("RUN	WITH:	logging	level	requested:	"	+	Level.INFO);
	 	 	 	 			App	anApp	=	new	App();
	 	 	 			}
			}
	 								catch	(OptionException	argsEx)
	 								{
	 									 	 System.out.println("ERROR:	Arguments\\parameter	is	not	valid.	"	+	argsEx);
	 								}
	 	}//EOM
	 	
	 /**
	 	*	Write	help	message	to	standard	output	using
	 	*	the	provided	instance	of	{@code	OptionParser}.
	 	*/
	 	private	static	void	printUsage(final	OptionParser	parser)
	 	{
	 						try
	 						{
	 									parser.printHelpOn(System.out);		
	 						}
	 						catch	(IOException	ioEx)
	 						{
	 									//	System.out.println("ERROR:	Unable	to	print	usage	-	"	+	ioEx);
	 									LOG.error("ERROR:	Unable	to	print	usage	-	"	+	ioEx);
	 						}
	 	}//EOM
				
	 /**
	 	*	View	the	arguments	presented	at	the	commandline
	 	*	This	is	for	debug	and	demo	purposes
	 	*/
	 	private	static	void	seeCommandlineInput(	String	args[]	)
	 	{	
	 	 if	(args.length	==	0)
								{
												System.out.println("There	were	no	commandline	arguments	passed!");
								}
	 	 else
		{
	 	 	 //	display	the	command	line		entered	
	 	 	 for(int	i	=	0;	i	<	args.length;	i++)	
			{
	 												System.out.println(args[i]);
	 												
	 								}
		}
			
	 	}//EOM
	 	
	 /**
	 	*	Test	the	Log4J2	logging
	 	*/
	 	private	static	void	testLogOutput()
	 	{
	 	 LOG.debug("Log	test:	Test	printed	on	debug");
	 				LOG.info("Log	test:	Test	printed	on	info");
	 				LOG.warn("Log	test:	Test	printed	on	warn");
	 				LOG.error("Log	test:	Test	printed	on	error");
	 				LOG.fatal("Log	test:	Test	printed	on	fatal");
	 				LOG.info("Appending	string:	{}.",	"Application	log	test	message	-	Hi");
			
	 	}//EOM
				
}//EOC