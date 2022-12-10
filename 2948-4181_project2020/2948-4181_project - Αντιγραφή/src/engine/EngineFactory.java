package engine;

public class EngineFactory {

	
	public IPlainTextDocumentEngine createEngine(String pFilePath, String pInputType, String pAlias) {
		
		return new Engine(pFilePath, pInputType,pAlias);
	}

	
}
