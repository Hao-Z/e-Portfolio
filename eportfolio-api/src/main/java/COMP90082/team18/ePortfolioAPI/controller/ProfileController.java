package COMP90082.team18.ePortfolioAPI.controller;

import COMP90082.team18.ePortfolioAPI.DTO.ProfileDTO;
import COMP90082.team18.ePortfolioAPI.DTO.Result;
import COMP90082.team18.ePortfolioAPI.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("users/{id}/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping
    public Result<ProfileDTO> getProfile(@PathVariable Long id){
        return profileService.getProfile(id);
    }

    @PatchMapping
    public Result<ProfileDTO> patchProfile(@PathVariable Long id, @RequestBody ProfileDTO profileDTO){
        return profileService.patchProfile(id, profileDTO.toProfile());
    }

}
