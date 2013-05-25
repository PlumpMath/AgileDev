// -----------------------------------------------------------------------
// <copyright file="CultivarTypeViewModelFactory.cs" company="Limagrain">
// Copyright © Limagrain 2013
// </copyright>
// -----------------------------------------------------------------------
namespace SIS.BOS.Presentation.Wpf.Cultivars.Controls.Documents.Cultivars.OpenEdit
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using Limagrain.Presentation.Core.Factories;
    using Limagrain.Presentation.Core.Models;
    using SIS.BOS.CrossCuttings.Core.Types;
    using SIS.BOS.DistributedServices.Proxies.BOSServicesReference;
    using SIS.BOS.Presentation.Core.DataModels.Cultivars;

    /// <summary>
    /// Factory used to build specific view models depending on the cultivar type and its multiplicity.
    /// </summary>
    public static class CultivarTypeViewModelFactory
    {
        /// <summary>
        /// Returns a view model for the specific cultivar type.
        /// It builds the view model depending on the cultivar type, and chooses the
        /// loader delegate depending on the multiplicity (single/multiple).
        /// </summary>
        /// <param name="cultivarTypeCode">Identifies the cultivar type.</param>
        /// <param name="parent">The specific cultivar to be fed to the view model.</param>
        /// <returns>Returns the Cultivar View Model</returns>
        public static OpenCultivarTabBaseViewModel CreateViewModel(string cultivarTypeCode, OpenCultivarViewModel parent)
        {
            int[] cultivarIds = parent.Ids.ToArray();
            bool multipleValues = cultivarIds.Length > 1;
            Func<ICollection<DataModelBase>> loader = null;
            OpenCultivarTabBaseViewModel vm = null;
            switch (cultivarTypeCode)
            {
                case CultivarTypes.BlendType:
                    loader = () =>
                    {
                        using (var services = ServicesFactory.GetService<BOSServicesClient, IBOSServices>())
                        {
                            var result = services
                                        .GetBlend(cultivarIds)
                                        .Select(x => new CultivarVarietyBlendDataModel(x));
                            return result.ToArray();
                        }
                    };

                    if (multipleValues)
                    {
                        vm = new Multiple.BlendCultivarTypeViewModel(parent, loader);
                    }
                    else
                    {
                        vm = new Single.BlendCultivarTypeViewModel(parent, loader,
                            (common, type) =>
                            {
                                using (var services = ServicesFactory.GetService<BOSServicesClient, IBOSServices>())
                                {
                                    if (type == null)
                                    {
                                        services.UpdateGeneralInfoAndHeader(common.Dto);
                                    }
                                    else
                                    {
                                        services.UpdateVarietyBlend(common.Dto, (type as CultivarVarietyBlendDataModel).Dto);
                                    }
                                }

                                return true;
                            });
                    }

                    break;

                case CultivarTypes.CompetitorHybridType:
                    loader = () =>
                    {
                        using (var services = ServicesFactory.GetService<BOSServicesClient, IBOSServices>())
                        {
                            var result = services
                                        .GetCompetitorHybrid(cultivarIds)
                                        .Select(x => new CultivarCompetitorHybridDataModel(x));
                            return result.ToArray();
                        }
                    };

                    if (multipleValues)
                    {
                        vm = new Multiple.CompetitorHybridCultivarTypeViewModel(parent, loader);
                    }
                    else
                    {
                        vm = new Single.CompetitorHybridCultivarTypeViewModel(parent, loader,
                            (common, type) =>
                            {
                                using (var services = ServicesFactory.GetService<BOSServicesClient, IBOSServices>())
                                {
                                    if (type == null)
                                    {
                                        services.UpdateGeneralInfoAndHeader(common.Dto);
                                    }
                                    else
                                    {
                                        services.UpdateCompetitorHybrid(common.Dto, (type as CultivarCompetitorHybridDataModel).Dto);
                                    }
                                }

                                return true;
                            });
                    }

                    break;

                case CultivarTypes.EarlyCodedHybridType:
                    loader = () =>
                    {
                        using (var services = ServicesFactory.GetService<BOSServicesClient, IBOSServices>())
                        {
                            var result = services
                                        .GetEarlyCodeHybrid(cultivarIds)
                                        .Select(x => new CultivarEarlyCodedHybridDataModel(x));
                            return result.ToArray();
                        }
                    };

                    if (multipleValues)
                    {
                        vm = new Multiple.EarlyCodedHybridCultivarTypeViewModel(parent, loader);
                    }
                    else
                    {
                        vm = new Single.EarlyCodedHybridCultivarTypeViewModel(parent, loader,
                            (common, type) =>
                            {
                                using (var services = ServicesFactory.GetService<BOSServicesClient, IBOSServices>())
                                {
                                    if (type == null)
                                    {
                                        services.UpdateGeneralInfoAndHeader(common.Dto);
                                    }
                                    else
                                    {
                                        services.UpdateEarlyCodedHybrid(common.Dto, (type as CultivarEarlyCodedHybridDataModel).Dto);
                                    }
                                }

                                return true;
                            });
                    }

                    break;

                case CultivarTypes.HybridType:
                    loader = () =>
                    {
                        using (var services = ServicesFactory.GetService<BOSServicesClient, IBOSServices>())
                        {
                            var result = services
                                        .GetHybrid(cultivarIds)
                                        .Select(x => new CultivarHybridDataModel(x));
                            return result.ToArray();
                        }
                    };

                    if (multipleValues)
                    {
                        vm = new Multiple.HybridCultivarTypeViewModel(parent, loader);
                    }
                    else
                    {
                        vm = new Single.HybridCultivarTypeViewModel(parent, loader,
                            (common, type) =>
                            {
                                using (var services = ServicesFactory.GetService<BOSServicesClient, IBOSServices>())
                                {
                                    if (type == null)
                                    {
                                        services.UpdateGeneralInfoAndHeader(common.Dto);
                                    }
                                    else
                                    {
                                        services.UpdateHybrid(common.Dto, (type as CultivarHybridDataModel).Dto);
                                    }
                                }

                                return true;
                            });
                    }

                    break;

                case CultivarTypes.InbredLineType: // Inbred and non inbred are in the same viewmodel.
                case CultivarTypes.NonInbredAccessionType:
                    loader = () =>
                    {
                        using (var services = ServicesFactory.GetService<BOSServicesClient, IBOSServices>())
                        {
                            var result = services
                                        .GetInbredOrAccession(cultivarIds)
                                        .Select(x => new CultivarInbredOrAccessionDataModel(x));
                            return result.ToArray();
                        }
                    };

                    if (multipleValues)
                    {
                        vm = new Multiple.InbredOrAccessionCultivarTypeViewModel(parent, loader);
                    }
                    else
                    {
                        vm = new Single.InbredOrAccessionCultivarTypeViewModel(parent, loader,
                            (common, type) =>
                            {
                                using (var services = ServicesFactory.GetService<BOSServicesClient, IBOSServices>())
                                {
                                    if (type == null)
                                    {
                                        services.UpdateGeneralInfoAndHeader(common.Dto);
                                    }
                                    else
                                    {
                                        services.UpdateInbredOrAccession(common.Dto, (type as CultivarInbredOrAccessionDataModel).Dto);
                                    }
                                }

                                return true;
                            });
                    }

                    break;

                default:
                    throw new InvalidOperationException("Unknown cultivar type received. Cannot create a viewmodel for that code.");
            }

            return vm;
        }
    }
}
