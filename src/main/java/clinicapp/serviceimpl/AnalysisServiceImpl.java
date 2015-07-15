package clinicspdata.serviceimpl;

import clinicspdata.entity.Analysis;
import clinicspdata.repositories.AnalysisRepository;
import clinicspdata.services.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Oleg Romanenchuk
 * Implementation
 */
@Service
public class AnalysisServiceImpl implements AnalysisService {

    @Autowired
    private AnalysisRepository analysisRepository;  // Analysis repository

    @Override
    public Analysis create(Analysis analysis) {
        return this.analysisRepository.saveAndFlush(analysis);
    }

    @Override
    public Analysis getById(Long id) {
        return this.analysisRepository.findById(id);
    }

    @Override
    public Analysis getByDate(String date) {
        return this.analysisRepository.findByDate(date);
    }

    @Override
    public List<Analysis> getAll() {
        return this.analysisRepository.findAll();
    }

    @Override
    public Analysis update(Analysis analysis) {
        return this.analysisRepository.saveAndFlush(analysis);
    }

    @Override
    public void delete(Long id) {
        this.analysisRepository.delete(id);
    }
}
