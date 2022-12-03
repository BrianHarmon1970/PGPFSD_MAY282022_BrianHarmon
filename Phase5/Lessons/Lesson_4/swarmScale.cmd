
IF NOT %1=='' (docker service scale webserver=%1) ELSE (ECHO 'USE: swarmScale scale)
	
