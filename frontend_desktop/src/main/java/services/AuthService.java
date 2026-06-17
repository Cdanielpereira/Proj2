public class CateringApi {
    private static final String BASE =
            "http://localhost:8080/proj2/catering";
    private final ObjectMapper mapper = new ObjectMapper();

    public List<CateringDto> getAll() throws Exception {
        var client = HttpClient.newHttpClient();
        var req = HttpRequest.newBuilder()
                .uri(URI.create(BASE)).build();
        var resp = client.send(req,
                HttpResponse.BodyHandlers.ofString());
        return mapper.readValue(resp.body(),
                mapper.getTypeFactory().constructCollectionType(
                        List.class, CateringDto.class));
    }

    public void delete(int id) throws Exception {
        var client = HttpClient.newHttpClient();
        var req = HttpRequest.newBuilder()
                .uri(URI.create(BASE + "/" + id))
                .DELETE().build();
        client.send(req, HttpResponse.BodyHandlers.discarding());
    }
}
