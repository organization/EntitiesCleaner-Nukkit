package entitiescleaner;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.scheduler.PluginTask;
import entitiescleaner.cleaner.CleanerManager;
import entitiescleaner.cleaner.EntityCleaner;

public class Main extends PluginBase {

	@Override
	public void onEnable() {
		CleanerManager.addCleaner(new EntityCleaner());
		
		getServer().getScheduler().scheduleRepeatingTask(new PluginTask<Main>(this) {

			@Override
			public void onRun(int currentTick) {
				CleanerManager.cleanEntities();
			}
		}, 20 * 60 * 3);
	}
}
