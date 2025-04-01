### **Documentação da Aplicação: Web Scraping e Transformação de Dados**

### **Objetivo**

O objetivo desta aplicação é realizar o scraping do site da ANS (Agência Nacional de Saúde Suplementar) para baixar arquivos PDF (Anexo I e Anexo II), compactar todos os anexos em um único arquivo formato ZIP, extrair os dados da tabela Rol de Procedimentos e Eventos em Saúde do PDF do Anexo I, salva-los em uma tabela estruturada no formato csv, compactar o csv no arquivo "Teste_Francinato.ZIP" e garantir que abreviações nas colunas OD e AMB sejam substituídas pelas descrições completas.

### **Estrutura do Projeto**

A aplicação está dividida em pacotes e classes:

- **Pacote `testWebScraping`**: Realiza o scraping e download dos PDFs.
    - **Classe `App`**: Classe principal que orquestra o processo.
    - **Classe `AnsScraper`**: Responsável pelo scraping do site e extração dos links de PDFs.
    - **Classe `PdfDownloader`**: Faz o download dos PDFs.
    - **Classe `ZipUtils`**: Compacta os arquivos em formato ZIP.
- **Pacote `testTransformacaoDeDados`**: Realiza a transformação dos dados do PDF em CSV e compactação.
    - **Classe `App`**: Classe principal que orquestra o processo.
    - **Classe `PdfTableExtractor`**: Extrai a tabela do PDF e retorna uma lista de dados.
    - **Classe `DataTransformer`**: Substitui abreviações dentro dos dados extraídos.
    - **Classe `CsvWriter`**: Salva os dados extraídos em um arquivo CSV.
    - **Classe `ZipUtils`**: Compacta o CSV em um arquivo ZIP.

### **Como Rodar a Aplicação**

1. **Certifique-se de que você tem o Maven configurado no seu ambiente de desenvolvimento**.
Se você estiver usando uma IDE como o IntelliJ IDEA ou o Eclipse, certifique-se de que o Maven está integrado corretamente.
2. **Instalação das Dependências:**
Execute o comando abaixo no terminal dentro da pasta do projeto para baixar as dependências necessárias:
    
    ```
    mvn clean install
    ```
    
3. **Execução do Código**:
A aplicação é executada em duas etapas:
    - **Etapa 1: Scraping e Download dos PDFs**:
        - Execute a classe `testWebScraping.App` para iniciar o processo de scraping e download.
        - A classe `AnsScraper` acessará a URL do site da ANS e extrairá os links dos arquivos PDF.
        - Em seguida, os PDFs serão baixados utilizando a classe `PdfDownloader`.
    - **Etapa 2: Processamento dos PDFs e Transformação dos Dados**:
        - Execute a classe `testTransformacaoDeDados.App` para iniciar o processamento dos arquivos baixados.
        - A classe `PdfTableExtractor` abrirá o PDF e processará os dados, extraindo a tabela relevante.
        - A classe `DataTransformer` substituirá as abreviações dentro dos dados extraídos.
        - A classe `CsvWriter` salvará os dados extraídos no formato CSV.
        - Por fim, a classe `ZipUtils` compactará o CSV gerado em um arquivo ZIP.
4. **Saída Esperada**:
    - O arquivo ZIP contendo o CSV gerado será salvo no diretório de execução com o nome `Teste_Francinato.z`.
5. **Verificação e Testes**:
    - **Verifique o arquivo ZIP gerado**: Após a execução, verifique se o arquivo ZIP contém o CSV esperado.
    - **Conteúdo do CSV**: Abra o CSV gerado para confirmar que os dados foram extraídos corretamente e as abreviações foram substituídas conforme esperado.
    - **Logs e Erros**: O código possui um tratamento básico de erros. Caso algum erro ocorra, ele será impresso no terminal.

### **Fluxo de Execução**

1. **Iniciar a execução**:
    - Ao executar a classe `testWebScraping.App`, o processo começa com a extração dos links dos PDFs usando a classe `AnsScraper`.
2. **Download dos PDFs**:
    - A classe `PdfDownloader` baixa os PDFs a partir dos links extraídos.
3. **Extração e Processamento dos Dados**:
    - O conteúdo do PDF é extraído pela classe `PdfTableExtractor`. Isso envolve ler o conteúdo do PDF, identificar as tabelas e transformá-las em uma estrutura de dados adequada.
4. **Substituição das Abreviações**:
    - As abreviações "OD" e "AMB" nas colunas são substituídas pelas descrições completas usando a classe `DataTransformer`.
5. **Geração do CSV**:
    - O arquivo CSV é criado utilizando a classe `CsvWriter`.
6. **Compactação do CSV**:
    - O CSV é compactado em um arquivo ZIP pela classe `ZipUtils`.
7. **Finalização**:
    - A execução é concluída e um arquivo ZIP contendo o CSV será gerado no diretório de trabalho.

### **Requisitos**

- Java 21 ou superior
- Maven 3.8+ (para gerenciar as dependências)
- Dependências do `jsoup`, `httpclient`, `pdfbox` e `opencsv`

### **Possíveis Problemas**

- **Erro de Download**: Se o site da ANS estiver fora do ar ou inacessível, o processo de scraping falhará. Isso será reportado com uma mensagem de erro.
- **Erro na Extração do PDF**: Se o PDF estiver com problemas de formatação ou com uma tabela mal estruturada, pode haver dificuldades para processar os dados corretamente. Verifique se o arquivo PDF é o correto e está acessível.

### **Conclusão**

Esse processo garante que você consiga realizar o scraping, extrair os dados e gerar um arquivo CSV compactado com sucesso. Use esta documentação para garantir que todos os passos estão sendo realizados corretamente durante o desenvolvimento e validação da aplicação.
