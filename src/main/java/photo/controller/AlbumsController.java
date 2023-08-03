package photo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import photo.dto.AlbumDto;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumsController {

    @PreAuthorize("hasAuthority('ROLE_developer') or #id == #jwt.subject")
    @GetMapping
    public List<AlbumDto> getAlbums() {

        AlbumDto album1 = new AlbumDto();
        album1.setAlbumId("albumIdHere");
        album1.setUserId("1");
        album1.setAlbumTitle("Album 1 title");
        album1.setAlbumDescription("Album 1 description");
        album1.setAlbumUrl("Album 1 URL");

        AlbumDto album2 = new AlbumDto();
        album2.setAlbumId("albumIdHere");
        album2.setUserId("2");
        album2.setAlbumTitle("Album 2 title");
        album2.setAlbumDescription("Album 2 description");
        album2.setAlbumUrl("Album 2 URL");

        return Arrays.asList(album1, album2);
    }
}
